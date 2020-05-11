package datanucleus;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.Map;
import dao.MapDao;
import dao.Markeur;
import dao.MarkeurDao;
import dao.User;
import dao.UserDao;
import dao.dn.MapDaoImpl;
import dao.dn.MarkeurDaoImpl;
import dao.dn.UserDaoImpl;



public class MarkeurDaoImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("DataSource");
		MarkeurDao markeurDao = new MarkeurDaoImpl(pmf);
		
		Markeur mark = new Markeur();
		Markeur mark2 = new Markeur();
		Markeur mark3 = new Markeur();
		mark.setLatitude(1.0);
		mark.setLongitude(1.0);
		markeurDao.addMarkeur(mark);
		markeurDao.addMarkeur(mark2);
		markeurDao.addMarkeur(mark3);
		Markeur nouveau = markeurDao.getMarkeur(1.0, 1.0);
		System.out.println(nouveau.getName());
		Assert.assertNotNull(nouveau);
		Assert.assertEquals(3, markeurDao.getAllMarkeur().size());
		Assert.assertTrue(markeurDao.deleteMarkeur(mark2));
		Assert.assertEquals(2, markeurDao.getAllMarkeur().size());
		Assert.assertTrue(markeurDao.modifyMarkeurName(mark,"paris"));
		Assert.assertTrue(markeurDao.modifyMarkeurMessage(mark,"Capitale gastronomique"));
	}
}