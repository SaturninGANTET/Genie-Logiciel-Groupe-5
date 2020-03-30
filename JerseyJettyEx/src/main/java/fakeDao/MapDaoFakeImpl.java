package fakeDao;

import exercice3.Map;
import exercice3.MapDao;

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
