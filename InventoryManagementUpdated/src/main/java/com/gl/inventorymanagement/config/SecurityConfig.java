package com.gl.inventorymanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gl.inventorymanagement.filter.JwtAuthFilter;

@Order(1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	 private JwtAuthFilter authFilter;

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Basant")
//                .password(encoder.encode("Pwd1"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("John")
//                .password(encoder.encode("Pwd2"))
//                .roles("USER","ADMIN","HR")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login","/register/user").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("get/seller/**").hasRole("ADMIN")
//                .and()
//                .httpBasic();
    	
//    	http.csrf().disable()
//        .authorizeHttpRequests().requestMatchers("/register/user","/add/seller","/add/product/{id}").permitAll().and()
//        .authorizeHttpRequests().
//        requestMatchers("api-seller/get","/placeorder/{ids}",
//        		"/add/order","/register/customer","api-admin/getCustomer","api-admin/getAllOrderProduct")
//        .hasRole("ADMIN").and()
//        .httpBasic();
    	http.csrf().disable()
    	.authorizeHttpRequests().requestMatchers(AUTH_WHITELIST).permitAll()
        .and()
        .authorizeHttpRequests().requestMatchers("api-customer/**").hasRole("CUSTOMER").and()
        .authorizeHttpRequests().requestMatchers("api-admin/**").hasRole("ADMIN").and()
        .authorizeHttpRequests().requestMatchers("api-order/**").hasAnyRole("ADMIN","CUSTOMER").and()
        .authorizeHttpRequests().requestMatchers("/api-seller/**").hasRole("SELLER").and()
        .httpBasic().and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
         
        return http.build(); 
    	
//        return http.build();
    }

    
    private static final String[] AUTH_WHITELIST= {
    		"/api/v1/auth/**",
    		"/v3/api-docs/**",
    		"/v3/api-docs.yaml",
    		"/swagger-ui/**",
    		"/swagger-ui.html",
    		"api-all/**",
    		"/authenticate"
    };
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
      authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    
  
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
