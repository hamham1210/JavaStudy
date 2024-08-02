package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.InvalidTransactionException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate {
	
	private static Database db = new Database();
	
	private Database() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
			
		}catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
		}
	}
	
	public static Database getInstance() {
		return db;
	}
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER,ServerInfo.PASSWORD);
		System.out.println("DB연결 성공");
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn!= null ) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!= null) rs.close();
		closeAll(ps, conn);
		
	}

	private boolean isExist(String ssn, Connection conn)throws SQLException {
		String query = "select ssn from customer where ssn =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, ssn);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
	
	
	////////////////////////////////////비즈니스 로직////////////////////////////////////////
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn= null;
		PreparedStatement ps = null;
		
		try {
			conn= getConnect();
			if(!isExist(cust.getSsn(), conn)) {//추가하려는 ssn이 존재하지 않는다면...
				String query = "insert into customer (ssn,cust_name,address) values (?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+"명 삽입성공");
				
			}else {
				throw new DuplicateSSNException("고객님은 이미 회원이십니다.");
			}
		} finally {
			closeAll(ps, conn);
		} 
		
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException, RecordNotFoundException {
		Connection conn= null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) {
				String query = "delete from customer where ssn = ?";
				ps= conn.prepareStatement(query);
				ps.setString(1, ssn);
				
				System.out.println(ps.executeUpdate()+ "명 삭제 성공");
				
			} else {
				throw new RecordNotFoundException ("고객님은 없는 회원입니다.");
			}
				
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, RecordNotFoundException {
		Connection conn= null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if (isExist(cust.getSsn(),conn)){
				String query = "update customer set cust_name=?, address=? where ssn=?;";
				ps= conn.prepareStatement(query);
				ps.setString(3, cust.getSsn());
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+ "명 수정 성공");
			}else {
				throw new RecordNotFoundException ("고객님은 없는 회원입니다.");
			}
		}
			finally {
				closeAll(ps, conn);
			}
		
	}

	@Override
	public ArrayList<SharesRec> getPortfolio(String ssn) throws SQLException {
		ArrayList<SharesRec> list = new ArrayList<SharesRec>();
		String query = "select ssn,symbol,quantity from shares where ssn = ?";
		try (Connection conn= getConnect();PreparedStatement ps=conn.prepareStatement(query);){
			
			ps.setString(1,ssn);
			ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			list.add(new SharesRec(rs.getString("ssn"), 
					rs.getString("symbol"), 
					rs.getInt("quantity")));
		}
		} 
		return list;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		CustomerRec cr = null;
		CustomerRec cs = null;
		ArrayList<SharesRec> list =getPortfolio(ssn);
		String query = "select ssn, cust_name, address from customer where ssn = ?";
		try (Connection conn= getConnect();PreparedStatement ps=conn.prepareStatement(query);){
			ps.setString(1,ssn);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cr = new CustomerRec( rs.getString("ssn"), 
						rs.getString("cust_name"), 
						rs.getString("address"),list);
				cs =new CustomerRec( rs.getString("ssn"), 
						rs.getString("cust_name"), 
						rs.getString("address"));
				
				System.out.println(cr+"내부 확인용");
			}
		
		}
		return cr;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		ArrayList<CustomerRec> list = new ArrayList<CustomerRec>();
		String query = "select ssn, cust_name, address from customer";
		try (Connection conn= getConnect();PreparedStatement ps=conn.prepareStatement(query);){
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new CustomerRec( rs.getString("ssn"), 
						rs.getString("cust_name"), 
						rs.getString("address")));
			}
		}
		return list;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		CustomerRec cr =  getCustomer(ssn);
		String query = "update shares set symbol=?, quantity=? where ssn=?;";
		try (Connection conn= getConnect();PreparedStatement ps=conn.prepareStatement(query);){
			
			ps.setString(3, ssn);
			ps.setString(1, symbol);
			ps.setInt(2, quantity);
		}
		
		
		
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity)
			throws SQLException, InvalidTransactionException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args)throws SQLException,RecordNotFoundException, DuplicateSSNException  {
		Database db = Database.getInstance();
		//고객 추가하기
//		db.addCustomer(new CustomerRec("777-777","하바라","서현동"));
		//고객정보 삭제하기
//		db.deleteCustomer("111-112");
		//고객정보 수정하기
		db.updateCustomer(new CustomerRec("777-777","하바라","종로동"));
		//포토 폴리오 가져오기
		db.getPortfolio("111-111").stream().forEach(i->System.out.println(i));
		//손님 정보 가져오기 및 list삽입
		System.out.println(db.getCustomer("111-111"));
		//손님 정보 리스트 가져오기
		db.getAllCustomers().stream().forEach(i->System.out.println(i));
		
		}

}
