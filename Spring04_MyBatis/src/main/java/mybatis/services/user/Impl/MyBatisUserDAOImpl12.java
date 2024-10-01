package mybatis.services.user.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

public class MyBatisUserDAOImpl12 implements UserDAO{
	
	//Dependency Inject...SqlSession이 필요하다...주입...setter
	private SqlSession sqlSession;
	//mapper의 이름 상수값으로 선언
	public static final String NS="UserMapper10.";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(NS+"addUser",user);
		//sqlSession.commit();//DML일때는 반드시 해야함.
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(NS+"removeUser",userId);
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(NS+"updateUser",user);
		
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = sqlSession.selectOne(NS+"getUser",userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> users=sqlSession.selectList(NS+"getUserList",user);
		return users;
	}

	
	
}