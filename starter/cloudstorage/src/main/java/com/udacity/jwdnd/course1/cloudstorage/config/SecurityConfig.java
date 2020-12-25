package com.udacity.jwdnd.course1.cloudstorage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/api/**","/img/**","/webjars/**","/css/**","/js/**","/signup")
			.permitAll()// only lets you view page with "/" or "/api"
			.anyRequest().authenticated() 	
				.and()
					.formLogin()
					.loginPage("/login") // login page url
					.defaultSuccessUrl("/home")
					// .failureUrl(authenticationFailureUrl)
					.permitAll()
				.and()
					.logout()
					.logoutSuccessUrl("/login?logout=true")
					// .logoutSuccessUrl("/login")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll()
				.and()
					.csrf()
					.disable();
	}

	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
    
	@Override 
	public void configure(WebSecurity web) throws Exception 
	{ web.ignoring() 
		.antMatchers("/h2/**","/images/**","/static/**","/resources/**");
	}
}