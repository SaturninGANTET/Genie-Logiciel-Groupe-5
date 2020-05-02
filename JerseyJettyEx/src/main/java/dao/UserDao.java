package dao;

import java.util.List;
/*
 * Create add and get, this methods is different from user cause it's use in the dao.
 */


public interface UserDao {

	
	// pour la vraie dao, il ne faudra pas faire un return vide.
	
	void addUser(User user);

	User getUserByEmail(String username);
	//List<User> getUser();
	
	List<User> getAllUser();
}

/*
List<User> getUser();
List<User> getUserName(String username);
List<User> putUser(String login, String password);
List<User> deleteUser(String username);
*/
