package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Configuration
public class MsgConfiguration {

	@Bean
	@SneakyThrows
	public SecurityFilterChain security(HttpSecurity http) {
		http.csrf(csrf->csrf.disable());  //You did not disable CSRF.Problem:GET works fine but 
		http.authorizeHttpRequests((req)->//POST / PUT / DELETE will give 403 Forbidden
		   req.requestMatchers("/contact")
		   .permitAll()
		   .anyRequest()
		   .authenticated()
				).httpBasic(Customizer.withDefaults());
	 return	http.build();
	}
}
