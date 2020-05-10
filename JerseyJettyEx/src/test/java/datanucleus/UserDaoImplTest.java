package datanucleus;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
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
/*		UserDao actionDao = new UserDaoImpl(pmf);
		
		long id;
		{
			PersistenceManager pm = pmf.getPersistenceManager();
			User user = new User();
			User ami = new User();
			user.getLfriends().add(ami);
			user = pm.makePersistent(user);	
			id = user.getId();
			pm.close();
		}
		
		{
			PersistenceManager pm = pmf.getPersistenceManager();

			User user = pm.getObjectById(User.class, id);
			Assert.assertEquals(1, user.getLfriends().size());
			System.out.println(user.getLfriends());
			System.out.println();
			pm.close();
		}
		*/
		
		UserDao actionDao = new UserDaoImpl(pmf);
		 
		
		
		List<User> lfriend = new ArrayList();
		List<Map> lmap = new ArrayList();

		Assert.assertEquals(0, actionDao.getAllUser().size());

		User action = new User();
		User ami = new User();
		ami.setName("toto");
		Map map = new Map();
		lfriend.add(0,action);
		lmap.add(0, map);
		
		action.setEmail("test");
		action.setPassword("mdp");
		action.setName("test");
		action.getLfriends().add(ami);
		actionDao.addUser(action);
		Assert.assertEquals(1, actionDao.getUserByEmail("test").getLfriends().size());
        Assert.assertEquals(action.getLfriends(), actionDao.getUserByEmail("test").getLfriends());
		action.setEmail("test");
		actionDao.addUser(action);
		action.setEmail("test");
		actionDao.addUser(action);	
		
		Assert.assertEquals(3, actionDao.getAllUser().size());
        Assert.assertTrue(actionDao.addUser(action));
        Assert.assertEquals("test", actionDao.getUserByEmail("test").getName());
        Assert.assertSame("test",actionDao.nomUser("test").get(0).getName());
        Assert.assertTrue(actionDao.modifyUserName("test","nouvelle"));
        Assert.assertEquals("nouvelle", actionDao.getUserByEmail("test").getName());
        Assert.assertEquals(lfriend.toString(), actionDao.getUserByEmail("test").getLfriends().toString());
        Assert.assertTrue(actionDao.deleteUser("nouvelle"));
        System.out.println(lfriend);
        Assert.assertTrue(actionDao.modifyUserLfriends("nouvelle",lfriend));
        Assert.assertTrue(actionDao.modifyUserLmap("nouvelle",lmap));
        User user = actionDao.getUserByEmail("test");
        System.out.println(lfriend.toString());
        System.out.println(user.getLfriends());
	
	}
}

