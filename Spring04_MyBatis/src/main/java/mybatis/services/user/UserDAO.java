package mybatis.services.user;



import java.util.List;

import mybatis.services.domain.User;

/*
 * 비지니스 로직의 템플릿...
 * ~mapping10.xml 보고서 작성
 * id값이 메소드 이름이 되고 parameterType이 인지값 resultMap이 리턴타입
 * */


public interface UserDAO {
	int addUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	int updateUser(User user) throws Exception;
	
	User getUser(String userId)throws Exception;
	
	List<User> getUserList(User user)throws Exception;
	
}
