package dao.fake;

import java.util.ArrayList;
import java.util.List;


import dao.Places;
import dao.PlacesDao;


//ça vu que toute les places sont dans les maps je sais pas si on a besoin d'un DAO vu qu'on en a deja un qui va construire les maps à partir de la base de données
public class PlacesFakeDao implements PlacesDao{
	

	public void addPlaces(Places places) {
		
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
