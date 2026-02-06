package in.ashokit;

import in.ashokit.Service.PersonService;
import in.ashokit.Service.TxService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.Service.PersonService;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
//		PersonService bean = context.getBean(PersonService.class);
//		bean.saveuser();
		
//		bean.getsort();
		
//		bean.getpagination();
		
//		bean.getQBE("male","india");
		
		TxService bean = context.getBean(TxService.class);
		
		bean.PersonWithContact();  
	}

}
