package datanucleus;


import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.Places;
import dao.PlacesDao;
import dao.dn.PlacesDaoImpl;

public class PlacesDaoImplTest {
	
	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		PlacesDao actionDao = new PlacesDaoImpl(pmf);

		Places action = new Places();
		action.setName("test");
		action.setMessage("mdp");
		action.setName("test");

		action.setPosition("test");
		actionDao.addPlaces(action);
		actionDao.addPlaces(action);	
		
		Assert.assertEquals(3, actionDao.getPlaces("test"));
		Assert.assertTrue(actionDao.modifyPlacesName("test","nouvelle"));
		Assert.assertTrue(actionDao.deletePlaces("nouvelle"));


	}
	

}
