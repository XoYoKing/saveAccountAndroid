package com.niu.bean;


public class SessionBean {
	public static SessionBean sessionBean;
	private String userID = "";
	private String userName;
	private String email = "";
	private String phone = "";
	private String role="";


	
	public static SessionBean getSessionBean() {
		return sessionBean;
	}

	public static void setSessionBean(SessionBean sessionBean) {
		SessionBean.sessionBean = sessionBean;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static synchronized SessionBean getInstance() {
		if (sessionBean == null) {
			sessionBean = new SessionBean();
		}
		return sessionBean;
	}
}
