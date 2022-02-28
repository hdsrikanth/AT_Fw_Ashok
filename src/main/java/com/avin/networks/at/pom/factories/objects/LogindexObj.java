package com.avin.networks.at.pom.factories.objects;

public class LogindexObj {

	private String username;
	private String password;

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public LogindexObj() { 	}

	public LogindexObj(String username, String password) {
		if(null != username && !"".equals(username)) {
			username = "ui-test\\" + username.toLowerCase();
		}
		this.username = username;
		this.password = password;
	}

	public LogindexObj setUserName(String username) {
		username = "ui-test\\" + username.toLowerCase();
		this.username = username;
		return this;
	}

	public LogindexObj setPassword(String password) {
		this.password = password;
		return this;
	}

}
