package dao.dn;


import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import dao.Map;
import dao.User;
import dao.UserDao;

import java.util.ArrayList;
import java.util.List;



// comment changer le nom de l'annotation @Test, aucune autre ne fonctionne


public class UserDaoImpl implements UserDao{
	//Create the dao with name Example
	private PersistenceManagerFactory pmf;
	
	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	public boolean addUser(User user) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.makePersistent(user);
		// sout essentiel sinon ça marche pas :)
		System.out.println(user.getLfriends());
		pm.close();
		return true;
	}
	
	/*
	public boolean addUser(User user) {
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			boolean b =true;
			try {
				tx.begin();
				pm.makePersistent(user);
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
		*/
	
	@SuppressWarnings("unchecked")
	public User getUserByEmail(String name) {
		List<User> users = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(User.class);
			q.declareParameters("String name");
			q.setFilter("email == name");
			
			users = (List<User>) q.execute(name);
			detached = (List<User>) pm.detachCopyAll(users);
			
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
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUser(){		
		List<User> users = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(User.class);
			users = (List<User>) q.execute();
			detached = (List<User>) pm.detachCopyAll(users);
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
	public boolean deleteUser(String friend) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		try{
			tx.begin();
			User user=this.nomUser(friend).get(0);
			int userid = user.id;
			if(user!=null) {
				Query q = pm.newQuery(User.class);
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
	public boolean modifyUserName(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setName(newname);
	                this.deleteUser(name);
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
	public boolean modifyUserPosition(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setPosition(newname);
	                this.deleteUser(name);
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
	public boolean modifyUserPassword(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setPassword(newname);
	                this.deleteUser(name);
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
	public boolean modifyUserEmail(String name,String newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setEmail(newname);
	                this.deleteUser(name);
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
	public boolean modifyUserLmap(String name,List<Map> newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setLmap(newname);
	                this.deleteUser(name);
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
	public boolean modifyUserLfriends(String name,List<User> newname) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		boolean b =true;
		 try {
	          	tx.begin();
	            User u = this.nomUser(name).get(0);
	            if(u!=null) {
	                u.setLfriends(newname);
	                this.deleteUser(name);
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
	@Override
	public List<User> nomUser(String search){
		List<User> map=null;
		List<User> detached= new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(User.class);
			q.declareParameters("String search");
			q.setFilter("name.startsWith(search)");
			map =(List<User>) q.execute(search);
			detached = (List<User>) pm.detachCopyAll(map);
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
	
	
		
	public void addFriend(User user, String friendName) {
		return;
	}
	
	public void addFriend(User user, User friend) {
		return;
	}
	
	public void removeFriend(User user, String friendName) {
		return;
	}
	
	public void removeFriend(User user, User friend) {
		return;
	}
	
	public void addMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, Map map) {
		return;
	}
	
	public void deleteMap(User user, int id) {
		return;
	}
}