package dao.dn;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import dao.Map;
import dao.MapDao;
import dao.Places;

import java.util.ArrayList;
import java.util.List;


public class MapDaoImpl implements MapDao{
	private PersistenceManagerFactory pmf;
	
	public MapDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Map> getMap(String catagorys) {
		
		List<Map> maps = null;
		List<Map> detached = new ArrayList<Map>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Map.class);
			q.declareParameters("String user");
			q.setFilter("username == user");
			
			maps = (List<Map>) q.execute(catagorys);
			detached = (List<Map>) pm.detachCopyAll(maps);
			
			tx.commit();
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	
}
