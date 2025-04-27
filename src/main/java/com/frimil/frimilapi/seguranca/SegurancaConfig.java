package com.frimil.frimilapi.seguranca;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SegurancaConfig {

    private FiltroSeguranca filtroSeguranca;



    private final String[] ENDPOINTS_RELEASED = {
            "autenticacao/login",
            "autenticacao/register",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    private final String[] ENDPOINTS_ADMIN = {
            "fazenda/**",
            "pecuarista/**",
            "pesador-gado/**",
            "transportadores/**",
            "veiculo/**"
    };

    private final String[] ENDPOINTS_ADMIN_USER = {

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers( ENDPOINTS_RELEASED).permitAll()

                        .requestMatchers(HttpMethod.GET, ENDPOINTS_ADMIN).hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, ENDPOINTS_ADMIN).hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, ENDPOINTS_ADMIN).hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, ENDPOINTS_ADMIN).hasAnyAuthority("ADMIN")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(filtroSeguranca, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
