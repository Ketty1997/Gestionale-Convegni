package com.example.demo.dto;

public class IscrittiDto {
	private int id;
	private String organizationName;
	private String name;
	private String surname;
	private String role;
	private String number;
	private String email;
	private String address;
	
	//costruttori
	public IscrittiDto() {}
	
	public IscrittiDto(int id) {
		this.id=id;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "IscrittiDto [id=" + id + ", organizationName=" + organizationName + ", name=" + name + ", surname="
				+ surname + ", role=" + role + ", number=" + number + ", email=" + email + ", address=" + address + "]";
	}
	
	
}
