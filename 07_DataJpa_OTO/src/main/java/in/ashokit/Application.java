package in.ashokit;

import in.ashokit.Service.PersonPassportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.Service.PersonPassportService;

@SpringBootApplication
   

public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
		PersonPassportService bean = context.getBean(PersonPassportService.class);
//		bean.save();
//		bean.getperson();
//		bean.getpassport();
//		bean.deleteperson();
		bean.deletepassport();
		
	}

}
