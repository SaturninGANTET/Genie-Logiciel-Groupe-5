package dao;

import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class ActionContainer {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;

	@Persistent
	protected List<Action> actions = null;

	public ActionContainer() {
		super();
		this.actions = new ArrayList<Action>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
