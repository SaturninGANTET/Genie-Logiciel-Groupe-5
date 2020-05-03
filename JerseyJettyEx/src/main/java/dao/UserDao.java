package dao;

import java.util.List;
/*
 * Create add and get, this methods is different from user cause it's use in the dao.
 */


public interface UserDao {

	
	// pour la vraie dao, il ne faudra pas faire un return vide.
	
	boolean addUser(User user);

	User getUserByEmail(String username);
	//List<User> getUser();
	
	List<User> getAllUser();
	boolean deleteUser(String friend);
	boolean modifyUserName(String name,String newname);
	boolean modifyUserPosition(String name,String newname);
	boolean modifyUserPassword(String name,String newname);
	boolean modifyUserEmail(String name,String newname);
	boolean modifyUserLmap(String name,List<Map> newname);
	boolean modifyUserLfriends(String name,List<User> newname);
	List<User> nomUser(String search);
}

/*
List<User> getUser();
List<User> getUserName(String username);
List<User> putUser(String login, String password);
List<User> deleteUser(String username);
*/
