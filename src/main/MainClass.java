package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.User;
import enumpkg.Role;

import util.Processing;

public class MainClass {

	public static void main(String[] args) {
		
		
			List<User>  users = new ArrayList<>();
			
			User admin = new User("theadmin", "theadmin", "John", "Doe", Role.ADMIN);
			
			User editor = new User("editor", "editor", "Average", "Joe", Role.EDITOR);
			
			users.add(admin);
			users.add(editor);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Please Login");
			System.out.println("Type Username");		
			String usrname = sc.nextLine();
			System.out.println("Type Password");
			String passwrd = sc.nextLine();
			
			//System.out.println(usrname + "  " + passwrd);
			
			//boolean check = true;
			
			if(Processing.loginGate(users, usrname, passwrd)) {
				if(Processing.isAdmin(users, usrname, passwrd)) {
					System.out.print("Admin menu options:  \n" 
							+ "Input user type CREATE  \n"
							+ "List users type LISTALL. \n"
							+ "List user type LIST. \n"
							+ "Edit user type EDIT \n"
							+ "Delete user type DELETE \n");
					String slct = sc.nextLine();
					
					while(!slct.equalsIgnoreCase("END")) {
						
						switch (slct) {
						  case "CREATE": {
						    //System.out.println("CREATE");						    
						    Processing.createUser(users);						    
						    break;
						  }
						  case "LISTALL": {
						    //System.out.println("LISTALL");
						    Processing.listAll(users);
						    break;
						  }
						  case "LIST": {
						    //System.out.println("LIST");
						    Processing.listUser(users);
						    break;
						  }
						  case "EDIT": {
						    //System.out.println("EDIT");
						    Processing.editUser(users);
						    break;
						  }
						  case "DELETE": {
						    //System.out.println("DELETE");
						    Processing.deleteUser(users);
						    break;
						  }
						}
						
						System.out.println("Choose option or type \"END\"  .");
						slct = sc.nextLine();
						continue;
						
					}					
				}else {
					System.out.println("In editor menu");
				}
				
			}else {
				System.out.println("END");	
			}		
		}
	}


