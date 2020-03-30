package dao;

import com.example.datanucleus.dao.fake.ActionDaoFakeImpl;

public class DAO {

	public static ActionDao getActionDao() {
		return new ActionDaoFakeImpl();
	}

}
