package com.liu.SecurityDemo1.config;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserDetailsService userDetailsService;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(password());
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/my-anon-page", "/aaa/**", "/abc").permitAll() // 保護しない URI
				.anyRequest().authenticated().and().csrf().disable();
	}

	@Bean
	PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
}
