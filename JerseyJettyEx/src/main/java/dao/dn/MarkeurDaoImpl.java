package dao.dn;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import dao.Markeur;
import dao.MarkeurDao;

public class MarkeurDaoImpl implements MarkeurDao {
	
private PersistenceManagerFactory pmf;
	
	public MarkeurDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	
	@SuppressWarnings("unchecked")
	public Markeur getMarkeur(Double lng, Double lat) {
		
		List<Markeur> markeur = null;
		List<Markeur> detached = new ArrayList<Markeur>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Markeur.class);
			q.declareParameters("Double lng, Double lat");
			q.setFilter("longitude == lng && latitude == lat");
		
			markeur = (List<Markeur>) q.execute(lng,lat);
			detached = (List<Markeur>) pm.detachCopyAll(markeur);
			
			tx.commit();
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		if(detached.size() == 0) {
			return null;
		}
		return detached.get(0);
	}
	
	@Override
	public boolean addMarkeur(Markeur markeur) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		try {
			tx.begin();
			pm.makePersistent(markeur);
			tx.commit();
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
	
	@Override
	public boolean deleteMarkeur(Markeur markeur) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		if(markeur == null) {
			return false;
		}
		try{
			tx.begin();
			int markeurId = markeur.id;
			if(markeur!=null) {
				Query q = pm.newQuery(Markeur.class);
				q.declareParameters("Integer markeurId");
				q.setFilter("id == markeurId");
				q.deletePersistentAll(markeurId);
				tx.commit();
			}
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
	
	@Override
	public boolean modifyMarkeurName(Markeur markeur,String newName) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            if(markeur!=null) {
	            	markeur.setName(newName);
	                this.deleteMarkeur(markeur);
	                pm.makePersistent(markeur);
	                tx.commit();
	            }
		 }
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
	
	@Override
	public boolean modifyMarkeurMessage(Markeur markeur,String newMessage) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            if(markeur!=null) {
	            	markeur.setMessage(newMessage);
	                this.deleteMarkeur(markeur);
	                pm.makePersistent(markeur);
	                tx.commit();
	            }
		 }
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
	
	@Override
	public boolean modifyMarkeurLongitude(Markeur markeur,Double newLongitude) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            if(markeur!=null) {
	            	markeur.setLongitude(newLongitude);
	                this.deleteMarkeur(markeur);
	                pm.makePersistent(markeur);
	                tx.commit();
	            }
		 }
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
	
	@Override
	public boolean modifyMarkeurLatitude(Markeur markeur,Double newLatitude) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            if(markeur!=null) {
	            	markeur.setLatitude(newLatitude);
	                this.deleteMarkeur(markeur);
	                pm.makePersistent(markeur);
	                tx.commit();
	            }
		 }
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return b;
	}
		

}
