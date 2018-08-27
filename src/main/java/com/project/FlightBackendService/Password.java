package com.project.FlightBackendService;

import org.springframework.stereotype.Component;

@Component
public class Password {
	private String password;

	public Password() {}
	public Password(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
