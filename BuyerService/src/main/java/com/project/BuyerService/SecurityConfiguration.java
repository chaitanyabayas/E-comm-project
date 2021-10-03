package com.project.BuyerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().deny().and().cors().and().csrf().disable();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {

		List<String> corsList = new ArrayList<>();
		corsList.add("*");

		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(corsList);
		configuration.setAllowedMethods(corsList);
		configuration.setAllowedHeaders(corsList);
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("Content-Type");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
