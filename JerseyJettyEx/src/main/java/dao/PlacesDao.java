package dao;

import java.util.List;

public interface PlacesDao {
	
	//on déclare les méthodes ici dans l'interface, et on les remplit dans le fakedao.


	List<Places> getPlaces(String name);
	
}
/*
List<Places> putPlaces();
List<Places> deletePlaces();
List<Places> getPlaces();
List<Places> getClosestPlaces(String position);
List<Places> getFriendsPlaces(User friend);// use with a user
List<Places> postPlaces();// to modify a places

*/
