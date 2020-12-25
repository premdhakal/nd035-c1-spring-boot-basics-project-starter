package com.udacity.jwdnd.course1.cloudstorage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class UsersEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int userId;
	private String username;
	private String salt;
	private String  password ;
	private String firstname;
	private String  lastname ;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	//Superconstructor
	public UsersEntity() {}
	
	//Constructor
	public UsersEntity(int userId, String username, String salt, String password, String firstname, String lastname) {
		super();
		this.userId = userId;
		this.username = username;
		this.salt = salt;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
}
