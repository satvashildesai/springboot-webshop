package com.practiceproject.webshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * In this method it will give popup basic authentication same as form based but
	 * we can't logout using this method. We can use default password(On console) or
	 * we can use password from db using UserDetailsService.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

//	-----------------------------------------------------------------------------------------------------------------

	/*
	 * It will provide form based configuration, **but it work only in incognito**
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

//		auth.inMemoryAuthentication().withUser("ajay").password("ajay@123").roles("ADMIN");
	}

//	---------------------------------------------------------------------------------------------------------------

	/*
	 * In this method it will give the form based authentication and we can logout
	 * too. We can use default username, password or we can read it from db
	 */

//	@Bean
//	public AuthenticationProvider authProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//
////		provider.setUserDetailsPasswordService(NoOpPasswordEncoder.getInstance());
//
//		return provider;
//	}

//	----------------------------------------------------------------------------------------------------------------

	/*
	 * Password encoder use to give the encryption information of password to
	 * validate user.
	 */

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

}
