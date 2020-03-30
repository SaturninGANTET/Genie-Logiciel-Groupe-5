package dao;

import java.util.ArrayList;
import java.util.List;

public class ActionDaoImpl implements ActionDao {

	private PersistenceManagerFactory pmf;

	public ActionDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	@SuppressWarnings("unchecked")
	public List<Action> getActions(String username) {
		List<Action> actions = null;
		List<Action> detached = new ArrayList<Action>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Action.class);
			q.declareParameters("String user");
			q.setFilter("username == user");

			actions = (List<Action>) q.execute(username);
			detached = (List<Action>) pm.detachCopyAll(actions);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void addAction(Action action) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();

			pm.makePersistent(action);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}

}
