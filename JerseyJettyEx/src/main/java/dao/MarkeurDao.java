package dao;


public interface MarkeurDao {
	
	boolean addMarkeur(Markeur markeur);

	Markeur getMarkeur(Double longitude, Double latitude);
	
	boolean deleteMarkeur(Markeur markeur);
	boolean modifyMarkeurName(Markeur markeur,String newName);
	boolean modifyMarkeurMessage(Markeur markeur,String message);
	boolean modifyMarkeurLongitude(Markeur markeur,Double longitude);
	boolean modifyMarkeurLatitude(Markeur markeur,Double latitude);
}
