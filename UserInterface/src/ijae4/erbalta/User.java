package ijae4.erbalta;


public class User {

	private String username;
	private char[] password;

	public User(String username, char[] cs) {
		this.username = username;
		this.password = cs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
}
