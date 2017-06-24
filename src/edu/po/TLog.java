package edu.po;

import java.sql.Timestamp;

/**
 * TLog entity. @author MyEclipse Persistence Tools
 */

public class TLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private Timestamp createdate;
	private String operation;

	// Constructors

	/** default constructor */
	public TLog() {
	}

	/** full constructor */
	public TLog(String username, Timestamp createdate, String operation) {
		this.username = username;
		this.createdate = createdate;
		this.operation = operation;
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

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}