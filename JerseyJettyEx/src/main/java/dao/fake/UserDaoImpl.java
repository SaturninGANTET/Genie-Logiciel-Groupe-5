package dao.fake;



import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.Map;
import dao.User;
import dao.UserDao;

// comment changer le nom de l'annotation @Test, aucune autre ne fonctionne

public class UserDaoImpl implements UserDao{
	
	/*
	private PersistenceManagerFactory pmf;
	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	*/
	Long userId = null;
	
	@Test
	public void getUser() {
		//Create the dao with name Example
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");

		// Save a container with 3 actions
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = new User();
			user.setName("name");
			user = pm.makePersistent(user);
			
			userId = user.getId();
			pm.close();
		}
		pmf.close();
	}

		// Retrieve this container
	public void addUser() {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
			
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = pm.getObjectById(User.class, userId);
			
			Assert.assertEquals("Donnee", user.getName());

			pm.close();
		}



	
	
	public boolean exists(String username){
		return true;
	}
	
	public void addUser(String login, String password) {
		return;
	}
	
	/*
	public void deleteUser(String username) {
		return;
	}
	*/
	
	public void addFriend(User user, String friendName) {
		return;
	}
	
	public void addFriend(User user, User friend) {
		return;
	}
	
	public void removeFriend(User user, String friendName) {
		return;
	}
	
	public void removeFriend(User user, User friend) {
		return;
	}
	
	public void addMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, Map map) {
		return;
	}
	
	public void deleteMap(User user, int id) {
		return;
	}
}