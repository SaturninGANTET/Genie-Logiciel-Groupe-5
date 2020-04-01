

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.example.datanucleus.dao.Action;
import com.example.datanucleus.dao.ActionContainer;

import exercice3.User;

public class UserTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		Long userId = null;

		// Save a container with 3 actions
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = new User();
			user.setName("Test");
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
