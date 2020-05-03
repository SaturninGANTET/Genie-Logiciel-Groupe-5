package datanucleus;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.User;
import dao.Map;
import dao.UserDao;
import dao.dn.UserDaoImpl;



public class UserDaoImplTest {

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		UserDao actionDao = new UserDaoImpl(pmf);
		
		List<User> lfriend = new ArrayList();
		List<Map> lmap = new ArrayList();

		Assert.assertEquals(0, actionDao.getAllUser().size());

		User action = new User();
		Map map = new Map();
		lfriend.add(action);
		lmap.add(map);
		
		action.setEmail("test");
		action.setPassword("mdp");
		action.setName("test");

		actionDao.addUser(action);
		action.setEmail("test");
		actionDao.addUser(action);
		action.setEmail("test");
		actionDao.addUser(action);	
		
		Assert.assertEquals(3, actionDao.getAllUser().size());
		
        Assert.assertTrue(actionDao.addUser(action));
        Assert.assertEquals("test", actionDao.getUserByEmail("test").getName());
        Assert.assertSame("test",actionDao.nomUser("test").get(0).getName());
        Assert.assertTrue(actionDao.modifyUserName("test","nouvelle"));
        Assert.assertTrue(actionDao.deleteUser("nouvelle"));
        
        Assert.assertTrue(actionDao.modifyUserLfriends("nouvelle",lfriend));
        Assert.assertTrue(actionDao.modifyUserLmap("nouvelle",lmap));
	}
}

