package com.clickncash.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.clickncash.auth.AuthEntryPoint;
import com.clickncash.auth.AuthRequestFilter;
import com.datical.liquibase.ext.rules.annotation.Condition;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService authUserDetailsService;

	@Autowired
	private AuthEntryPoint unauthorizedHandler;

	@Bean
	public AuthRequestFilter jwtAuthenticationFilter() {
		return new AuthRequestFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(authUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg", "/**/*.html",
						"/**/*.css", "/**/*.js", "/scanner/*", "/rest/auth/login","/rest/auth/signup","/rest/auth/course/list",
						"/rest/auth/course/getOne","/rest/auth/course/getFeatures","/rest/auth/user/teacherByCourse",
						"/rest/auth/course/totalEnroll","/rest/auth/course/getTopics","/rest/auth/course/search",
						"/rest/auth/ratings/count","/rest/auth/course/live","/rest/auth/course/upcoming","/rest/auth/user/totalStdTechr",
						"/rest/auth/ratings/testimonial","/rest/auth/course/addQuery",
						"/rest/auth/send-otp","/rest/auth/verify-otp","/rest/auth/resetPassword")
				.permitAll()
				// Remove /** from below. Only for testing
				.antMatchers("*/rest/auth/login", "/rest/auth/createUser", "/rest/auth/user/generateNewPassword", "/rest/auth/generateToken","/auth/**", "/v2/api-docs", "/configuration/ui", "/swagger-resources",
						"/configuration/security", "/swagger-ui.html", "/webjars/**",
						"/swagger-resources/configuration/ui", "/swagger-ui.html", "/scanner/**")
				.permitAll().anyRequest().authenticated();
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}