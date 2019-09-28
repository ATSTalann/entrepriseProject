package com.viptic.entrepriseApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.viptic.entrepriseApp.security.jwt.*;
import com.viptic.entrepriseApp.security.services.UserDetailsServiceImpl;

 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan("com.viptic.entrepriseApp.*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
	 @Autowired
	
	    UserDetailsServiceImpl userDetailsService;
	 
	    @Autowired
	    private JwtAuthEntryPoint unauthorizedHandler;

	    @Bean(name = "passwordEncoder")
	    public PasswordEncoder passwordEncoder() {
	    	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	    
	    @Bean
	    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
	        return new JwtAuthTokenFilter();
	    }
	 
	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        authenticationManagerBuilder
	                .userDetailsService(userDetailsService)
	                .passwordEncoder(passwordEncoder());
	    }
	 
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	  
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	        http.cors().and().csrf().disable().
	                authorizeRequests()
	                .antMatchers("/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    }
    
   
}
