package in.ashokit.config;

import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;

import in.ashokit.filter.AppFilter;
import in.ashokit.service.CustomerService;
import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Autowired
	private AppFilter  filter;
	
    @Autowired
    private CustomerService cserv;
	
	@Bean
	public BCryptPasswordEncoder pwdencoder() {
		return new BCryptPasswordEncoder();
	}

	

	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider authunicate = new DaoAuthenticationProvider();
		authunicate.setPasswordEncoder(pwdencoder());
		authunicate.setUserDetailsService(cserv);
		return authunicate;
	}
	
	@Bean
	@SneakyThrows
	public AuthenticationManager authManager(AuthenticationConfiguration config) {
		return  config.getAuthenticationManager();
	}
	
	@Bean
	@SneakyThrows
	public SecurityFilterChain security(HttpSecurity http) {

	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(req -> req
	            .requestMatchers("/register", "/login").permitAll()
	            .anyRequest().authenticated()
	        )
	        .sessionManagement(session ->
	            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        )
	        .authenticationProvider(provider())
	        .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();
	}

}
