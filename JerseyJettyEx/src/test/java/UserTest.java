import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import dao.User;
import dao.UserDao;
import dao.dn.UserDaoImpl;

public class UserTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		UserDao actionDao = new UserDaoImpl(pmf);

		Assert.assertEquals(0, actionDao.getUser("user1").size());

		User action = new User();
		action.setEmail("user1");
		action.setTitle("A title");
		action.setContent("A content");

		actionDao.addAction(action);

		Assert.assertEquals(1, actionDao.getActions("user1").size());

		DAO.getActionDao().getActions("user1");
	}

}
