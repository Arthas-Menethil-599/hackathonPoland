package com.example.hackathon.config;

import com.example.hackathon.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/css/**", "/js/**").permitAll();


        http.authorizeRequests()
                .requestMatchers("/admins/")
                .hasRole("ADMIN");

//        http.authorizeRequests()
//                .requestMatchers("/organizations/")
//                .hasRole("ORGANIZATION");
//
//        http.authorizeRequests()
//                .requestMatchers("/volunteers/")
//                .hasRole("VOLUNTEER");
//
//        http.authorizeRequests()
//                .requestMatchers("/sponsors/")
//                .hasRole("SPONSOR");

        http.formLogin(form -> form.loginPage("/login").permitAll()
                .loginProcessingUrl("/auth").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .successForwardUrl("/")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error"));


        http.logout((logout) -> logout.logoutUrl("/logout").permitAll());
        return http.build();
    }

    private AccountService service;

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(bcryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setService(AccountService service) {
        this.service = service;
    }
}