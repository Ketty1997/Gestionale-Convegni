package com.example.demo.dto;

public class AmministratoriDto {
	private int id;
	private String nameAdmin;
	private String surnameAdmin;
	private String emailAdmin;
	private String password;
	
	//costruttori
	public AmministratoriDto() {}
	
	public AmministratoriDto(int id) {
		this.id=id;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameAdmin() {
		return nameAdmin;
	}
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	public String getSurnameAdmin() {
		return surnameAdmin;
	}
	public void setSurnameAdmin(String surnameAdmin) {
		this.surnameAdmin = surnameAdmin;
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
