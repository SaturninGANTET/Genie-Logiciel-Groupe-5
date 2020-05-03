package dao.fake;

import java.util.ArrayList;
import java.util.List;


import dao.Places;


//ça vu que toute les places sont dans les maps je sais pas si on a besoin d'un DAO vu qu'on en a deja un qui va construire les maps à partir de la base de données
public class PlacesFakeDao{
	
/*
	public boolean addPlaces(Places places) {
		
	}
public boolean modifyPlacesName(String name,String newname) {
		
	}
public boolean modifyPlacesMessage(String name,String newname) {
	
}
public boolean modifyPlacesPosition(String name,String newname) {
	
}

*/
public void deletePlaces(String friend) {
	
}
	
	public List<Places> getPlaces(String name) {
		
		Places places = new Places();
		places.setName(name);
		List<Places> result = new ArrayList<Places>();
		result.add(places);

		return result;
	}

	/*
	public void getClosestPlaces(String position) {
		return;
	}
	public void postPlaces(Places place) {
		return;
	}
	*/
	
}
