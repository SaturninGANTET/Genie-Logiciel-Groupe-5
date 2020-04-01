package dao.fake;

import dao.Map;
import dao.MapDao;

public class MapDaoFakeImpl implements MapDao{

	public Map getMapById(int id) {
		return new Map();
	}
	public void deleteMap(int id) {
		return;
	}
	
	public void deleteMap(Map map) {
		return;
	}
	
	public void updateMap(Map map) {
		return;
	}
}
