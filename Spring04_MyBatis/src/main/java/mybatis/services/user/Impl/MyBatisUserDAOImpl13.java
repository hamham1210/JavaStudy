package mybatis.services.user.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
/*
 * Component
 * Layer별로 조금 더 디테일하게 부를 수 명칭
 * 
 * Presentation Layer | Service Layer | Persistance Layer
 * @Controller			@Service		@Repository
 * */

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	
	
	@Autowired//해당 의존성을 어노테이션으로 주입
	private SqlSession sqlSession;
	
	public static final String NS="UserMapper10.";


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
