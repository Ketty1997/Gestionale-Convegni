package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class CustomSecurityConfig {

    @Bean //Indica che il metodo securityFilterChain() sarà usato per creare un oggetto speciale che definisce le regole di sicurezza per il progetto.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) //Il CSRF (Cross-Site Request Forgery) è una misura di sicurezza che impedisce attacchi specifici. Qui viene disabilitato perché non è necessario per il tuo caso.
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() //Questa riga dice che tutte le richieste al sito saranno permesse senza autenticazione.
                //Ad esempio, chiunque potrà accedere alla pagina di login.
            )
            .formLogin(login -> login.disable()); //Disabilita il login predefinito di Spring Security, in modo che venga usata la tua pagina personalizzata (/admin/login.jsp) invece di quella predefinita

        return http.build();
    }
}