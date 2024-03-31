package org.cris6h16.Spring_Security_Filters.Security;

import org.cris6h16.Spring_Security_Filters.Security.Filter.Impl.Filter1;
import org.cris6h16.Spring_Security_Filters.Security.Filter.Impl.Filter2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        // filter order is numerated
        // you can see filters in project execution logs
        http
                .csrf(Customizer.withDefaults())    // 1. `CsrfFilter`
                .authorizeHttpRequests(authorize -> // 3. `AuthorizationFilter`
                        authorize.anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())// 2. BasicAuthenticationFilter
                .formLogin(Customizer.withDefaults())// 2. UsernamePasswordAuthenticationFilter

                .addFilterAfter(new Filter1(), AuthorizationFilter.class)// 4. Filter1
                .addFilterAfter(new Filter2(), Filter1.class);           // 5. Filter2
        return http.build();

    }
}
