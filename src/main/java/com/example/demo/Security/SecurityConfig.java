package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Wyłączamy ochronę CSRF dla prostoty (czasem to ona powoduje pętle przy POST)
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // ZMIANA: Dodano "/error" - to przerywa pętlę, jeśli wystąpi błąd w kodzie HTML
                        .requestMatchers("/Quiz/register", "/Quiz/login", "/error", "/css/**", "/js/**", "/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/Quiz/login")
                        .loginProcessingUrl("/Quiz/login") // To musi pasować do th:action w formularzu
                        .defaultSuccessUrl("/Quiz/categories", true)
                        .failureUrl("/Quiz/login?error=true") // Jawne wskazanie gdzie iść po błędzie
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/Quiz/login")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}