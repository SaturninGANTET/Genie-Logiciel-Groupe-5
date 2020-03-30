package fakeDao;

import exercice3.Places;
import exercice3.PlacesDao;


//ça vu que toute les places sont dans les maps je sais pas si on a besoin d'un DAO vu qu'on en a deja un qui va construire les maps à partir de la base de données
public class PlacesFakeDao implements PlacesDao{

	public void putPlaces(Places place) {
		return;
	}
	public void deletePlaces(Places place) {
		return;
	}
	
	// J'sais pas trop quoi demander en argument en vrai
	public Places getPlaces() {
		return new Places();
	}
	public void getClosestPlaces(String position) {
		return;
	}
	public void postPlaces(Places place) {
		return;
	}
	
}
