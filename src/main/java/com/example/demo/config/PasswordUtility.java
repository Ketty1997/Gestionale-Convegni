package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//Crei un oggetto per criptare le password
	        String rawPassword = "password123"; // La tua password in chiaro
	        String encodedPassword = encoder.encode(rawPassword); // Cripta la password
	        System.out.println(encodedPassword);

	}

}
