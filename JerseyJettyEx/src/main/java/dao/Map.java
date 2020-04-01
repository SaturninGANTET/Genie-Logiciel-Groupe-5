package dao;

import java.util.List;

/**
 * 
 *contain a list of places.
 */
public class Map {
	private String State;
	private String catagory;
	private String owner;
	private List<Places> Lplaces;
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public List<Places> getLplaces() {
		return Lplaces;
	}
	public void setLplaces(List<Places> lplaces) {
		Lplaces = lplaces;
	}
	
	
}

