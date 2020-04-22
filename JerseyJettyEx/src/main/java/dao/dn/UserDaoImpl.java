package dao.dn;


import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.junit.Test;

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
	
	@SuppressWarnings("unchecked")
	public List<User> getUser(String name) {
		
		List<User> users = null;
		List<User> detached = new ArrayList<User>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try{
			tx.begin();
			Query q = pm.newQuery(User.class);
			q.declareParameters("String user");
			q.setFilter("username == user");
			
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
		return detached;
	}

	public void addUser(User user) {

			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
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

		}

	public void deleteUser(String name) {
		return;
	}
	

	public boolean exists(String username){
		return true;
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