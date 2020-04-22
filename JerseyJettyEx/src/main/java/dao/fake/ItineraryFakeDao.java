package dao.fake;

import java.util.ArrayList;
import java.util.List;

import dao.Itinerary;
import dao.ItineraryDao;


public class ItineraryFakeDao {

	public List<Itinerary> getItinerary(Itinerary itinerarys) {
		itinerarys = new Itinerary();
		itinerarys.setTime("20 minutes");

		List<Itinerary> result = new ArrayList<Itinerary>();
		result.add(itinerarys);

		return result;
	}
	
	
}
