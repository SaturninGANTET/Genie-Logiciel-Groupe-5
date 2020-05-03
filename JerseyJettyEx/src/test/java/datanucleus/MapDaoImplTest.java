package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.Map;
import dao.MapDao;
import dao.User;
import dao.UserDao;
import dao.dn.MapDaoImpl;
import dao.dn.UserDaoImpl;



public class MapDaoImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		MapDao mapDao = new MapDaoImpl(pmf);

		Assert.assertEquals(0, mapDao.getAllMap().size());
		Map map = new Map();
		map.setName("A name");	
		mapDao.addMAp(map);
		Assert.assertEquals(1, mapDao.getAllMap().size());
		
		
        map = mapDao.getAllMap().get(0);
        System.out.println(map.id);
        mapDao.addMAp(map);
        Assert.assertEquals(2, mapDao.getAllMap().size());
        //mapDao.modifyMapName(map, "A new Name");
        //Assert.assertEquals("A new name", mapDao.getMapById(1).getName());
		/*
        Assert.assertEquals("test", actionDao.getUserByEmail("test").getName());
        Assert.assertSame("test",actionDao.nomUser("test").get(0).getName());
        Assert.assertTrue(actionDao.modifyUserName("test","nouvelle"));
        Assert.assertTrue(actionDao.deleteUser("nouvelle"));
        */
	}
}