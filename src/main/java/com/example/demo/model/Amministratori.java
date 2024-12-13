package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Amministratori implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Genera chiave primaria
	private int id;
	private String nameAdmin;
	private String surnameAdmin;
	private String emailAdmin;
	private String password;
	
	
	//costruttori
	public Amministratori() {}
	
	public Amministratori(int id) {
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
