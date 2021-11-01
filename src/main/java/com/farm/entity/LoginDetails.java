package com.farm.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {

	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String username;
	private String pwd;
	
	@Enumerated(EnumType.STRING)
	private Role role; 
	
	public LoginDetails()
	{
		
	}

	public LoginDetails(long userid, String username, String pwd, Role role) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.role = role;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginDetails [userid=" + userid + ", username=" + username + ", pwd=" + pwd + ", role=" + role + "]";
	}

	
}
