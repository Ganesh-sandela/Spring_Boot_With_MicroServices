package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.webclient.async.WebClient_Async;
import in.ashokit.webclient.sync.WebClient_sync;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
//		WebClient_sync bean = run.getBean(WebClient_sync.class);
//		bean.getClient();
		
		WebClient_Async bean = run.getBean(WebClient_Async.class);
		bean.getclientAsync();
	}

}
