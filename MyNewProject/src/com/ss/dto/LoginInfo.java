package com.ss.dto;

import java.io.Serializable;

public class LoginInfo implements Serializable
{
	private static final long serialVersionUID = 3875707091325080285L;
	
	private String username;
	private String password;
	
	public LoginInfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	@Override
	public boolean equals(Object o) 
	{
		if (o instanceof LoginInfo)
		{
			LoginInfo other = (LoginInfo) o;
			
			if(other.getUsername().equals(this.getUsername()) &&
				other.getPassword().equals(this.getPassword())) 
			{
				return true;
			}
		}
		
		return false;
	}
}
