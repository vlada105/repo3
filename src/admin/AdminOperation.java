package admin;

import java.util.List;
import java.util.Scanner;

import entity.Role;
import modifikator.OperationUsers;
import user.User;


public class AdminOperation extends User implements OperationUsers {



	public AdminOperation(String firstname, String lastname, String username, String password, Role role) {
		super(firstname, lastname, username, password, role);
		
	}

	
	
	public boolean checkLoggedInUser(List<User> users, String username, String password)
	{
		for (User user : users) {
			if((user.getUsername().equals(username)) && (user.getPassword().equals(password)))
					{
						return true;
					}
		}
		return false;
	}
	
	public boolean findAdmin(List<User> users, String username, String password)
	{
		for (User user : users) {
			if((checkLoggedInUser(users, username, password)) && (user.getRole().equals(Role.ADMIN)))
			{
				return true;
			}
		}
		return false;
	}
	
		public boolean checkIsCharackterNumber(String password) {
				
			char[] pass = new char[password.length()];
			pass = password.toCharArray();
				
				for (char c : pass) {
					if(Character.isDigit(c))
					{
						return true;
					}
				}
				
				return false;
			}

		public boolean checkPassword(String password)
		{
			char[] pass = new char[password.length()];
			pass = password.toCharArray();
			if(Character.isLetter(pass[0]) && checkIsCharackterNumber(password))
			{
				return true;
			}
			
			return false;
		}
	


	@Override
	public void addUser(List<User> users, String username, String password) {
		
		
		
		String firstname=null, lastname=null;
		
		Scanner scanner = new Scanner(System.in);
			
		
		for (User user : users) {
			if(user.getUsername().equals(username))
			{
				System.out.println("ERROR!!! This username already exists, try with another username: ");
				username = scanner.next();
				
			}
			else
				if((!(checkIsCharackterNumber(password))))
				{
					System.out.println("ERROR!!! Password is incorect, try with another password: ");
					password = scanner.next();
					
				}
		}
		
		System.out.println("Enter firstname: ");
		firstname = scanner.next();
		System.out.println("Enter lastname: ");
		lastname = scanner.next();
		
		User newUser = new AdminOperation(firstname, lastname, username, password, Role.EDITOR);
		users.add((User) newUser);
		
		System.out.println("New user added");
		
	}
	
	@Override
	public void showAllUsers(List<User> users) {
	
		System.out.println("List of all users");
		for (User user : users) {
			System.out.println(user);
		}
		
	}

	@Override
	public User findUser(List<User> users, String username) {
		
		
		for (User user : users) {
			if((user.getUsername().equals(username)))
			{
				return user;
			}
			
		}
		return null;
	}

	@Override
	public void showUser(List<User> users, String username) {
		
		User pom = findUser(users, username);
		if(pom == null)
		{
			System.out.println("User not exists");
		}
		else
		{
			System.out.println(pom.getFirstname() + " " + pom.getLastname() + " " + pom.getRole());
		}
		
	}


	@Override
	public void editUser(List<User> users, String username) {
		
		User editUser = findUser(users, username);
		if(editUser != null)
		{
			String firstname, lastname, pomUsername, pomPassword;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter new firstname: ");
			firstname = scanner.next();
			System.out.println("Enter new lastname: ");
			lastname = scanner.next();
			System.out.println("Enter new username: ");
			pomUsername = scanner.next();
			System.out.println("Enter new password: ");
			pomPassword = scanner.next();
			
			if(checkPassword(pomPassword))
			{
				editUser.setPassword(pomPassword);
			}
			
			editUser.setUsername(pomUsername);
			editUser.setLastname(lastname);
			editUser.setFirstname(firstname);
			
			
			System.out.println(editUser);
		}
		else
		{
			System.out.println("User not exists");
		}
	}

	@Override
	public void deleteUsers(List<User> users, String username) {
		
		User pomDelete = findUser(users, username);
		users.remove(pomDelete);
		System.out.println("DELETE USER: " + pomDelete);
		
	}

	

	


	

	

	

}
