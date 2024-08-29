package web.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.Resultset;

/*
 * Connection 반환하는 방식이 
 * DriverManager방식이 아닌 DataSource방식으로 진행...
 * Naming(JNDI) Service가 사용된다.
 * ::
 * 1)DataSource를 먼저 반아온 다음에
 * 2)1)번 안에 있는 미리 만들어져 있는 Connection을 하나 Rent해 와서 사용할 것이다.
 * */


public class MemberDAOImpl implements MemberDAO{
	
	//추가..
	private DataSource ds;
	//싱글톤
	
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		//Naming Service작업 진행.
		try {
		InitialContext ic = new InitialContext();
		ds= (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
		System.out.println("DataSource lookup...Succuece");
		}catch(NamingException e) {
			System.out.println("DataSource lookup...Fail");
		}
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("디비 연결 성공");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!= null) ps.close();
		if(conn!=null)conn.close();
		
	}
	
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(ps,conn);
	}

	@Override
	public void registerMember(Member vo) throws SQLException {
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
	try {
		conn= getConnect();
		String query="INSERT into member (id,password,name,address) values(?,?,?,?);";
		ps = conn.prepareStatement(query);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPassword());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		System.out.println(ps.executeUpdate()+"명 직원등록 완료");
	} finally {
		closeAll(rs,ps,conn);
	}
	
	}

	@Override
	public ArrayList<Member> showAllMember() throws SQLException {
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			conn= getConnect();
			String query= "select id, password, name, address from member";
			ps = conn.prepareStatement(query);
			
			
			rs= ps.executeQuery();
			while(rs.next()) {
				list.add(new Member(rs.getString("id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("address")
						)) ;
			}
		} finally {
			closeAll(rs,ps,conn);
		}
		return list;
	}

	@Override
	public Member findByIdMember(String id) throws SQLException {
		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		Member vo = null;
		try {
			conn= getConnect();
			String query= "select id, password, name, address from member where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				vo = new Member(id,rs.getString("password"),rs.getString("name"),rs.getString("address")
						);
			}
		} finally {
			closeAll(rs,ps,conn);
		}
		
		
		return vo ;
	}
	/*
	public static void main(String[] args)throws Exception {
	Member rvo=	MemberDAOImpl.getInstance().findByIdMember("kosta");
	System.out.println(rvo);
	}단위 테스트 불가/현재는 connection을 서버로부터 가져오기 때문이다.
*/
}
