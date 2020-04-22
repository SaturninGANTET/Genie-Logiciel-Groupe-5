package dao.dn;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import dao.Places;
import dao.PlacesDao;

import java.util.ArrayList;
import java.util.List;

public class PlacesDaoImpl implements PlacesDao {
	private PersistenceManagerFactory pmf;
	
	public PlacesDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Places> getPlaces(String name) {
		
		List<Places> places = null;
		List<Places> detached = new ArrayList<Places>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Places.class);
			q.declareParameters("String user");
			q.setFilter("username == user");
			
			places = (List<Places>) q.execute(name);
			detached = (List<Places>) pm.detachCopyAll(places);
			
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
