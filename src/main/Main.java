package main;

import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import admin.AdminOperation;
import entity.Role;
import modifikator.OperationUsers;

public class Main {

	public static void main(String[] args) {
		
		List <User> users = new ArrayList<>();
		
		OperationUsers admin = new AdminOperation("Petar","Petrovic" ,"admin", "admin",Role.ADMIN);
		User user = new User("Marko", "Markovic", "mare", "mare", Role.EDITOR);
		User user2 = new User("Zarko", "Zarkovic", "zare", "zare", Role.EDITOR);
		User user3 = new User("Zeljko", "Zeljkovic", "zeljko", "zeljko", Role.EDITOR);
		User user4 = new User("Dusan", "Markovic", "dule", "dule", Role.EDITOR);
		
		
		users.add((User) admin);
		users.add(user);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		
		
		String username, password,confrmPassword = null;
		int counter = 4;
		int option;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		username = scanner.next();
		System.out.println("Enter password: ");
		password = scanner.next();
		
		while(!admin.checkLoggedInUser(users,username,password))
		{
			counter--;
			System.out.println("ERROR LOGIN! Remaining logging attempts: " + counter);
			if(counter == 0)
			{
				System.out.println("YOU HAVE " + counter + " ATTEMTS, please try again later");
				break;
				
			}
			System.out.println("Enter username: ");
			username = scanner.next();
			System.out.println("Enter password");
			password = scanner.next();
		}
		
		//System.out.println((admin.checkLoggedInUser(users, username, password)) || (!(admin.findAdmin(users, username, password))));
		
		if(admin.findAdmin(users, username, password))
			{
				System.out.println("ADMIN LOGIN, please choose one of options: ");
				System.out.println("Option 1: Create new user\n" +
									"Option 2: Show all users\n" +
									"Option 3: Show user\n " +
									"Option 4: Edit user\n" +
									"Option 5: Delete user");
				option = scanner.nextInt();
				switch (option) {
				case 1: 
					{
						System.out.println("Enter username: ");
						username = scanner.next();
						System.out.println("Enter password");
						password = scanner.next();
						admin.addUser((List<User>)users, username, password);
						break;
					}
				case 2:
					{
						admin.showAllUsers(users);
						break;
					}
				case 3: 
					{
						System.out.println("Enter username of user you want to show: ");
						username = scanner.next();
						admin.showUser(users,username);
						break;
					}
				case 4:
					{
						System.out.println("Enter username of user you want to edit: ");
						username = scanner.next();
						admin.editUser(users,username);
						break;
					}
				case 5:
					{
						System.out.println("Enter username of user you want to delete: ");
						username = scanner.next();
						admin.deleteUsers(users,username);
						break;
					}
				default:
					throw new IllegalArgumentException("Unexpected value: " + option);
				}
			}
		else
		{
			System.out.println("User menu");
		}
		
			
		
		
		
	
	}

}
