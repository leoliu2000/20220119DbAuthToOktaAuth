package com.liu.SecurityDemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class SecurityConfig1 extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pwString = passwordEncoder.encode("111");
		auth.inMemoryAuthentication().withUser("liu").password(pwString).roles("admin");
	}

	@Bean
	PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
}
