package dao.fake;

import java.util.ArrayList;
import java.util.List;

import dao.User;



public class UserFakeDao {
	
	public List<User> getUser(User users) {
		users = new User();
		users.setName("name");
		users.setPosition("position");

		List<User> result = new ArrayList<User>();
		result.add(users);

		return result;
	}
}
