package edu.po;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {
	
	private static final long serialVersionUID = 22409479335640310L;
	
	// Fields
	private Integer id;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}