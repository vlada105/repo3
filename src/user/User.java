package user;

import entity.Role;

public class User {
	
	private final String firstname;
	private final String lastname;
	private final String username;
	private final String password;
	private final Role role;
	
	

	public User(String firstname, String lastname, String username, String password, Role role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.role = role;
	}



	@Override
	public String toString() {
		return "Admin: firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password=" + password ;
	}
	
	
	
	
	
	

}
