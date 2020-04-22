package dao;

import javax.jdo.PersistenceManagerFactory;
import dao.dn.UserDaoImpl;
import dao.fake.UserFakeDao;


public class Dao {
	// pmf en static pour qu'il n'y ait pas d'erreur. static a retirer.
	
	static PersistenceManagerFactory pmf = null;
	private static boolean onoff = false;

	public static void setTest(boolean onoff) {
		Dao.onoff = onoff;
	}
	
	public static UserDao getUserDao() {
		if(onoff) {
			return (UserDao) new UserFakeDao();
		}else {
			return new UserDaoImpl(pmf);
		}
	}
}
