package dao;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 
 *contain a list of places.
 */
@PersistenceCapable
public class Map {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	public int id = 0;
	
	private String Name;
	private String State;
	private String catagory;
	private String owner;
	private List<Places> Lplaces;
	
	public String getName() {
		return this.Name;
	}
	
	public void setName(String newName) {
		this.Name = newName;
	}
	
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

