package flightbooking.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher("/**") // Apply this config to all paths
            .authorizeHttpRequests((authorize) -> authorize
                .anyRequest().permitAll() // Allow everything
            )
            .csrf((csrf) -> csrf.disable()); // Disable CSRF for Postman or testing

        return http.build();
    }
}
