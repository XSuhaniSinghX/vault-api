package com.vault.vault.config;
//11th class
// This class configures the security settings for the Vault application.
//didnt originally plan on doing this but i guess i have to now because DAMN SPRING SECURITY!!
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/auth/register", "/auth/login").permitAll() // allow register & login
            .anyRequest().authenticated()
        );
    return http.build();
}
}
