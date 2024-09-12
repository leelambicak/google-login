package com.example.mydemogithub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class Security {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
     
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
                .requestMatchers("/bank/**").permitAll()
                .anyRequest().authenticated())
        .oauth2Login(Customizer.withDefaults());
return http.build();
}

}
