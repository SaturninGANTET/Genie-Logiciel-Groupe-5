

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.User;

public class UserTest {
	//layer = nom de la table dans la base de donnée
	
	@Test
	public void test() {
		//Create the dao with name Example
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		Long userId = null;

		// Save a container with 3 actions
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = new User();
			user.setName("Test");
			user.setEmail("email");
			user = pm.makePersistent(user);
			
			userId = user.getId();
			
			pm.close();
		}

		// Retrieve this container
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = pm.getObjectById(User.class, userId);
			
			Assert.assertEquals("Test", user.getName());

			pm.close();
		}

		pmf.close();
	}

}
