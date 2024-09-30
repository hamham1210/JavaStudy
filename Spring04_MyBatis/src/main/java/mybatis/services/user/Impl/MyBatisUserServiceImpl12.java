package mybatis.services.user.Impl;

import java.util.List;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;

public class MyBatisUserServiceImpl12 implements UserService{
	//의존성 주입
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);
		
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDAO.updateUser(user);
		
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = userDAO.getUser(userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> users =userDAO.getUserList(user);
		return users;
	}

}
