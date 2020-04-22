package dao.dn;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import dao.Itinerary;
import dao.ItineraryDao;
import dao.Places;

import java.util.ArrayList;
import java.util.List;


public class ItineraryDaoImpl implements ItineraryDao{
	private PersistenceManagerFactory pmf;
	
	public ItineraryDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Itinerary> getItinerary(String time) {
		
		List<Itinerary> itinerarys = null;
		List<Itinerary> detached = new ArrayList<Itinerary>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Itinerary.class);
			q.declareParameters("String user");
			q.setFilter("username == user");
			
			itinerarys = (List<Itinerary>) q.execute(time);
			detached = (List<Itinerary>) pm.detachCopyAll(itinerarys);
			
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
