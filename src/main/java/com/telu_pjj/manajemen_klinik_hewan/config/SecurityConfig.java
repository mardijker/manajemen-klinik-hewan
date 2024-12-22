package com.telu_pjj.manajemen_klinik_hewan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/login", "/register").permitAll()  // Allow access to login and register
                    .anyRequest().authenticated()  // All other requests require authentication
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")  // Custom login page
                    .defaultSuccessUrl("/home")  // Redirect to home on success
                    .permitAll()  // Allow all users to access the login page
            )
            .logout(logout ->
                logout
                    .permitAll()  // Allow all users to log out
            );

        return http.build();  // Build the HttpSecurity
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoder bean
    }
}