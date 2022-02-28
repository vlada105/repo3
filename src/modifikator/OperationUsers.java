package modifikator;

import java.util.List;

import user.User;

public interface OperationUsers {

	public boolean checkLogin(List<User> users, String username, String password);
	
	public void showAllUsers(List<User> users);
	
	public User findUser(List<User> users, String username);
	
	public void showUser(List<User> users,String username);
	

	
	public void deleteUsers(List<User> users, String username);
	
	public void addUser(List<User> users,String username, String password);

	

	public boolean checkLoggedInUser(List<User> users, String username, String password);

	public boolean findAdmin(List<User> users, String username, String password);

	public void editUser(List<User> users, String username);

	
	
}
