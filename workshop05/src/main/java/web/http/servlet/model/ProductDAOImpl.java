package web.http.servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO {
	// 추가..
	private DataSource ds;
	private static ProductDAOImpl dao = new ProductDAOImpl();

	public ProductDAOImpl() {
		// Naming Service작업 진행.
		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource lookup...Succuece");
		} catch (NamingException e) {
			System.out.println("DataSource lookup...Fail");
		}
	}

	public static ProductDAOImpl getInstance() {
		return dao;
	}

	@Override
	public Connection getConnect() throws SQLException {
		System.out.println("디비 연결 성공");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();

	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		closeAll(ps, conn);
		if (rs != null)
			rs.close();
	}

	@Override
	public void registerProduct(Product vo) throws SQLException {
		String query = "INSERT INTO Product(name,price,description) values(?,?,?);";
		try (Connection conn = getConnect(); PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getExplain());
			System.out.println(ps.executeUpdate() + "명 추가되었습니다.");
		}

	}

	@Override
	public ArrayList<Product> findProducts() throws SQLException {
		String query = "SELECT num,name,price,description FROM Product;";
		ArrayList<Product> list = new ArrayList<Product>();
		try (Connection conn = getConnect();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				list.add(new Product(rs.getInt("num"), rs.getString("name"), rs.getInt("price"),
						rs.getString("description")));
			}
		}
		for(Product p :list) {
			System.out.println(p);
		}
		return list;
	}

}
