package dao;

import javax.jdo.PersistenceManagerFactory;

public class Dao {

	PersistenceManagerFactory pmf = null;
	private static boolean onoff = false;

	public static void setTest(boolean onoff) {
		Dao.onoff = onoff;
	}
	
	public static UserDao getUserDao() {
		if(onoff) {
			return new UserDaoFakeImpl();
		}else {
			return new UserDaoImpl(pmf);
		}
	}
}
