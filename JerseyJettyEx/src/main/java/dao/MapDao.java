package dao;

import java.util.List;

public interface MapDao {

	List<Map> getMap(String catagorys);

	boolean deleteMap(Map map);

	boolean modifyMapName(Map map, String newName);

	List<Map> getAllMap();

	boolean addMAp(Map map);

	Map getMapById(int ids);
}
