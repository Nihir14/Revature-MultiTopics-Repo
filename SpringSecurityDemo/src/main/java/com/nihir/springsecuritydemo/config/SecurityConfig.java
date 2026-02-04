package com.nihir.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.net.http.HttpRequest;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public UserDetailsService userdetailservice(PasswordEncoder encoder) {

        UserDetails admin=User.withUsername("nihir")
                .password(encoder.encode("nihir"))
                .roles("ADMIN").build();


        UserDetails user = User.withUsername("revature")
                .password(encoder.encode("revature"))
                .roles("USER").build();

        return new InMemoryUserDetailsManager(admin,user);
    }


    @Bean
    public SecurityFilterChain securityfilter(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/employees/home").permitAll()

                        .requestMatchers("/employees/**").authenticated()
                )
                .formLogin(withDefaults());

        return http.build();
    }



    //csrf --
    @Bean
    public PasswordEncoder passwordencode(){
        return new BCryptPasswordEncoder();
}

}
 