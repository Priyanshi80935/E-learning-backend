package com.tech;

import com.tech.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity //It will enable the web security and the configration wiil be manage in this class
public class SecurityConfig {
    @Autowired
    private ApplicationUserService applicationUserService;

    private static final String[] AUTH_WHITELIST = {
            "/api/register/student",
            "/api/course/top-course",
            "api/lecture"
    };


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                .requestMatchers(AUTH_WHITELIST) //It will not give restriction for APIs
                .permitAll() //Permit all
                .anyRequest() //any other request please authonticate
                .authenticated()
        ).
                httpBasic(Customizer.withDefaults())
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("*"));
                    configuration.setAllowedMethods(List.of("*"));
                    configuration.setAllowedHeaders(List.of("*"));
                    return configuration;
                }))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
    }


    @Bean //It will create object or bean for application container (IOC)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(applicationUserService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
