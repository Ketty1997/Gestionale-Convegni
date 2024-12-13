package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration //Indica che questa classe contiene configurazioni specifiche per il progetto (in questo caso, la configurazione per il criptaggio delle password)
public class SecurityConfig {
	//Questa classe definisce come le password verranno criptate (ovvero trasformate in una stringa sicura che non può essere letta direttamente).
	   @Bean //Dice a Spring che il metodo passwordEncoder() deve essere usato per creare un oggetto "speciale" che può essere usato in tutto il progetto.
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); // È un algoritmo di criptaggio molto usato. Trasforma una password normale (come "password123") in una stringa criptata
	    }
}
