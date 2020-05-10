package dao.dn;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

import dao.Map;
import dao.MapDao;
import dao.Places;
import dao.User;

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
	
	@SuppressWarnings("unchecked")
	public Map getMapById(int ids) {
		List<Map> maps = null;
		List<Map> detached = new ArrayList<Map>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Map.class);
			q.declareParameters("int ids");
			q.setFilter("id == id");
			maps = (List<Map>) q.execute(ids);
			detached = (List<Map>) pm.detachCopyAll(maps);
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
	
	//////////////////////////////////////////////////// ! A majuscule dans le nom de la fonction
	@Override
	public boolean addMAp(Map map) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		try {
			tx.begin();
			pm.makePersistent(map);
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
	@SuppressWarnings("unchecked")
	public List<Map> getAllMap(){		
		List<Map> maps = null;
		List<Map> detached = new ArrayList<Map>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(Map.class);
			maps = (List<Map>) q.execute();
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
	

	@Override
	public boolean deleteMap(Map map) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		if(map == null) {
			return false;
		}
		try{
			tx.begin();
			int mapId = map.id;
			if(map!=null) {
				Query q = pm.newQuery(User.class);
				q.declareParameters("Integer mapId");
				q.setFilter("id == mapId");
				q.deletePersistentAll(mapId);
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
	public boolean modifyMapName(Map map,String newName) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            if(map!=null) {
	                map.setName(newName);
	                this.deleteMap(map);
	                pm.makePersistent(map);
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


	/////////////////////////////////////////////////////
	
	
}
