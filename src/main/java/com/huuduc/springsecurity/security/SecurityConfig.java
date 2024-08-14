package com.huuduc.springsecurity.security;

import com.huuduc.springsecurity.model.data.CustomeUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomeUserDetailService customeUserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> {
                    httpSecurityCsrfConfigurer
                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                })
                // CSRF
//                .csrf(httpSecurityCsrfConfigurer -> {
//                    httpSecurityCsrfConfigurer
//                            .disable();
//                })
                .authorizeHttpRequests(register -> {
                    register.requestMatchers("/","/home","/register/**","/login").permitAll();
                    register.requestMatchers("/admin/**").hasRole("ADMIN");
                    register.requestMatchers("/user/**").hasRole("USER");
                    register.anyRequest().authenticated();
//                    register.anyRequest().permitAll();
                })
                //  Clickjacking
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer
                            .frameOptions().sameOrigin();
                })
                //Session Fixation
                .sessionManagement(httpSecuritySessionManagementConfigurer -> {
                    httpSecuritySessionManagementConfigurer
                            .sessionFixation()
//                            .none();
                            .migrateSession();
                })
                .formLogin(httpSecurityFormLoginConfigurer -> {
                    httpSecurityFormLoginConfigurer
                            .loginPage("/login")
                            .successHandler(new AuthenticationSuccessHandle())
                            .permitAll();
                })
                .build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(AbstractHttpConfigurer::disable)
////                .csrf(httpSecurityCsrfConfigurer -> {
////                    httpSecurityCsrfConfigurer
////                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
////                })
//                .authorizeHttpRequests(register -> {
//                    register.requestMatchers("/","/home","/register/**","/login").permitAll();
//                    register.requestMatchers("/admin/**").hasRole("ADMIN");
//                    register.requestMatchers("/user/**").hasRole("USER");
//                    register.anyRequest().authenticated();
////                    register.anyRequest().permitAll();
//                })
//                .sessionManagement(httpSecuritySessionManagementConfigurer -> {
//                    httpSecuritySessionManagementConfigurer
//                            .sessionFixation()
//                            .none();
////                            .migrateSession();
//                })
////                .headers(httpSecurityHeadersConfigurer -> {
////                    httpSecurityHeadersConfigurer
////                            .frameOptions().sameOrigin();
////                })
//                .formLogin(httpSecurityFormLoginConfigurer -> {
//                    httpSecurityFormLoginConfigurer
//                            .loginPage("/login")
//                            .successHandler(new AuthenticationSuccessHandle())
//                            .permitAll();
//                })
//                .build();
//    }
////    @Bean
////    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
////        return configuration.getAuthenticationManager();
////    }

    //    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customeUserDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return customeUserDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
