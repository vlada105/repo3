package util;

import java.util.List;
import java.util.Scanner;

import entity.User;
import enumpkg.Role;

public interface Processing {

	public static boolean loginGate(List<User> users, String username, String password) {
		Scanner sc = new Scanner(System.in);
		int logCount = 4;

		while (!isLoggedin(users, username, password)) {
			logCount--;
			System.out.println("Login Failed. Remaining attempts: " + logCount);
			if (logCount == 0) {
				return false;
			}
			System.out.println("Type Username");
			username = sc.nextLine();
			System.out.println("Type Password");
			password = sc.nextLine();
			continue;
		}
		return true;
	}

	public static boolean isLoggedin(List<User> users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAdmin(List<User> users, String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)
					&& user.getRole().equals(Role.ADMIN)) {
				return true;
			}
		}
		return false;
	}

	public static void createUser(List<User> users) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username. Must be unique.");
		String username = sc.nextLine();
		while (!isUnique(users, username)) {
			System.out.println("Already exists. Please choose another");
			username = sc.nextLine();
			continue;
		}
		System.out.println("Enter password. Must start with letter and contain number");
		String password = sc.nextLine();
		while (!passwordOK(password)) {
			System.out.println("Password not OK. Try again");
			password = sc.nextLine();
			continue;
		}

		System.out.println("Enter first name");
		String firstname = sc.nextLine();

		System.out.println("Enter last name");
		String lastname = sc.nextLine();

		User user = new User(username, password, firstname, lastname, Role.EDITOR);

		users.add(user);

		System.out
				.println("User : " + username + "created with Editor role by default. To change this go to edit user.");

	}

	public static boolean passwordOK(String password) {
		char[] charPass = password.toCharArray();
		if (Character.isLetter(charPass[0]) && containsNumber(charPass)) {
			return true;
		}
		return false;
	}

	public static boolean containsNumber(char[] charArray) {
		for (char c : charArray) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isUnique(List<User> users, String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

	public static void listAll(List<User> users) {
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

	public static void listUser(List<User> users) {
		System.out.println("Enter Username");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		while (!isValid(users, username)) {
			System.out.println("Invalid user. Try Again");
			username = sc.nextLine();
			continue;
		}
		User temp = getUser(users, username);
		if (temp != null) {
			System.out.println(temp.toString());
		} else {
			System.out.println("Unknown Error");
		}
	}

	public static boolean isValid(List<User> users, String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public static User getUser(List<User> users, String username) {
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public static void editUser(List<User> users) {
		System.out.println("Enter Username");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		while (!isValid(users, username)) {
			System.out.println("Invalid user. Try Again");
			username = sc.nextLine();
			continue;
		}
		User user = getUser(users, username);
		if (user != null) {
			System.out.println("Enter new password for user" + username);
			String newPass = sc.nextLine();
			while (!passwordOK(newPass)) {
				System.out.println("Password not OK. Try again");
				newPass = sc.nextLine();
				continue;
			}
			user.setPassword(newPass);

			System.out.println("Enter firstname for user" + username);
			String firstname = sc.nextLine();
			user.setFirstname(firstname);

			System.out.println("Enter lastname for user" + username);
			String lastname = sc.nextLine();
			user.setLastname(lastname);
			
			System.out.println("Enter ROLE for user" + username + ". Note: ADMIN or EDITOR ");
			Role nRole;
			String newRole = sc.nextLine();
						
			while(!(newRole.equals("ADMIN") || newRole.equals("EDITOR"))) {
					System.out.println("Wrong Input. Try Again.");
					newRole = sc.nextLine();
					continue;
				}
			if(newRole.equals("ADMIN")) {				
				nRole = Role.ADMIN;
			}else {
				nRole = Role.EDITOR;
			}
			
			user.setRole(nRole);
			System.out.println("Finished");

		} else {
			System.out.println("Unknown Error");
		}
	}

	public static void deleteUser(List<User> users) {
		System.out.println("Enter Username of User You Want To Delete");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		while (!isValid(users, username)) {
			System.out.println("Invalid user. Try Again");
			username = sc.nextLine();
			continue;
		}		
		User user = getUser(users, username);
		users.remove(user);
		System.out.println("Deleted");
		
	}

}
