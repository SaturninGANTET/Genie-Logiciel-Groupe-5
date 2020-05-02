package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.User;
import dao.UserDao;
import dao.dn.UserDaoImpl;



public class UserDaoImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		UserDao actionDao = new UserDaoImpl(pmf);
		

		Assert.assertEquals(0, actionDao.getAllUser().size());

		User action = new User();
		action.setEmail("nouvelle");
		action.setPassword("mdp");
		action.setName("nouvelle");

		actionDao.addUser(action);
		action.setEmail("nouvelle");
		actionDao.addUser(action);
		action.setEmail("nouvelle");
		actionDao.addUser(action);	
		
		Assert.assertEquals(3, actionDao.getAllUser().size());
		
        Assert.assertTrue(actionDao.addUser(action));
        Assert.assertEquals("nouvelle", actionDao.getUserByEmail("nouvelle").getName());
        Assert.assertSame("nouvelle",actionDao.nomUser("nouvelle").get(0).getName());
        Assert.assertTrue(actionDao.deleteUser("nouvelle"));
	}
}

