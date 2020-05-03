package dao.fake;

import dao.Map;
import dao.MapDao;

import java.util.ArrayList;
import java.util.List;


public class MapFakeDao{// implements MapDao{

	public List<Map> getMap(String catagorys) {
		Map maps = new Map();
		maps.setCatagory("restaurant");

		List<Map> result = new ArrayList<Map>();
		result.add(maps);

		return result;
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
