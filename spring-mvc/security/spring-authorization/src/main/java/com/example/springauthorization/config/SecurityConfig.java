package com.example.springauthorization.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable
                ).authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/error", "/error/**").permitAll() // Cho phép truy cập vào /error
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/", "/register", "/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
                                .anyRequest().authenticated()
                ).formLogin((config) ->
                        config
                                .loginPage("/login") // Đường dẫn tới trang đăng nhập
                                .defaultSuccessUrl("/") // Điều hướng về trang chủ sau khi đăng nhập thành công
                                .permitAll()
                ).logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                );


        return http.build();
    }
}
