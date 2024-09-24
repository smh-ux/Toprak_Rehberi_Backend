package com.example.Internship.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/login", "/api/users/register", "/api/tokens/generate", "/api/tokens/validate", "/api/successrate/evaluate", "/api/successrate/fetch", "/api/successrate/byNeighborhood/{neighborhoodId}", "/api/productinfofull/fetch", "/api/productinfo/fetch", "/api/products/adding", "/api/products/fetching", "/api/products/land/{landId}", "/api/products/period/{periodId}", "/api/products/successRate/{successrateId}", "/api/products/evaluate", "/api/lands/adding", "/api/lands/fetching", "/api/lands/user/{userId}", "/api/lands/delete/{landId}", "/api/location/cities", "/api/location/towns/{cityId}", "/api/location/neighborhoods/{townId}").permitAll()
                        .anyRequest().authenticated() // Bunlar dışında hepsi için doğrulama istemesi için
                )
                .httpBasic(withDefaults()); // Http doğrulaması

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Giriş yapabilecek kullanıcı ayarlamak için
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
