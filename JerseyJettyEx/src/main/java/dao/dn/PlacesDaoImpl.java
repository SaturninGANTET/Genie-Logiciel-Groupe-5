package dao.dn;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import dao.Places;
import dao.PlacesDao;
import dao.User;

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
	
	public boolean addPlaces(Places places) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		try {
			tx.begin();
			pm.makePersistent(places);
			
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
	public boolean deletePlaces(String friend) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		try{
			tx.begin();
			Places user=this.nomPlaces(friend).get(0);
			int userid = user.id;
			if(user!=null) {
				Query q = pm.newQuery(Places.class);
				q.declareParameters("Integer userid");
				q.setFilter("id == userid");
				q.deletePersistentAll(userid);
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
	public boolean modifyPlacesName(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	          	Places u = this.nomPlaces(name).get(0);
	            if(u!=null) {
	                u.setName(newname);
	                this.deletePlaces(name);
	                pm.makePersistent(u);
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
	public boolean modifyPlacesMessage(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            Places u = this.nomPlaces(name).get(0);
	            if(u!=null) {
	                u.setMessage(newname);
	                this.deletePlaces(name);
	                pm.makePersistent(u);
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
	public boolean modifyPlacesPosition(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            Places u = this.nomPlaces(name).get(0);
	            if(u!=null) {
	                u.setPosition(newname);
	                this.deletePlaces(name);
	                pm.makePersistent(u);
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
	
	@SuppressWarnings({ "unchecked", "finally" })
	public List<Places> nomPlaces(String search){
		List<Places> map=null;
		List<Places> detached= new ArrayList<Places>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Places.class);
			q.declareParameters("String search");
			q.setFilter("name.startsWith(search)");
			map =(List<Places>) q.execute(search);
			detached = (List<Places>) pm.detachCopyAll(map);
			tx.commit();
		}
		finally {
			if(tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			return detached;
		}
	}
	
}
