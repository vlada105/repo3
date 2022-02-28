package user;

import java.util.List;

import entity.Role;

public class User {
	
		protected String firstname;		
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		protected String lastname;		
		private String username;		
		private String password;
		private Role role ;

		public User(String firstname, String lastname, String username, String password, Role role) {
			
			this.firstname = firstname;
			this.lastname = lastname;
			this.username = username;
			this.password = password;
			this.role = role;
			
		
	}
	

	public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public Role getRole() {
			return role;
		}


		public void setRole(Role role) {
			this.role = role;
		}


		public String getFirstname() {
			return firstname;
		}


	@Override
	public String toString() {
		return "User firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + " " + role;
	}


	
	

}
