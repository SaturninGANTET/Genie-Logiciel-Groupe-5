package fakeDao;

import java.util.ArrayList;
import java.util.List;

import exercice3.Map;
import exercice3.User;
import exercice3.UserDao;

public class UserDaoFakeImpl implements UserDao{
	public User getUser(String username) {
		return new User();
	}
	public boolean exists(String username){
		return true;
	}
	
	public void addUser(String login, String password) {
		return;
	}
	
	public void deleteUser(String username) {
		return;
	}
	
	public void addFriend(User user, String friendName) {
		return;
	}
	
	public void addFriend(User user, User friend) {
		return;
	}
	
	public void removeFriend(User user, String friendName) {
		return;
	}
	
	public void removeFriend(User user, User friend) {
		return;
	}
	
	public void addMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, String name) {
		return;
	}
	
	public void deleteMap(User user, Map map) {
		return;
	}
	
	public void deleteMap(User user, int id) {
		return;
	}
}