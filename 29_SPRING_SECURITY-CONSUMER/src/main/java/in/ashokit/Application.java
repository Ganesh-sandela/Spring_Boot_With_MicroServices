package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		HttpHeaders header= new HttpHeaders();
	       header.setBasicAuth("gani", "gani123");
	       HttpEntity<String> getEntity = new HttpEntity<>(header);
	String url="http://localhost:9090/welcome";
	RestTemplate rt = new RestTemplate();
	ResponseEntity<String> entity = rt.exchange(url, HttpMethod.GET, getEntity, String.class);
	System.out.println(entity.getBody());
		
	}

}
