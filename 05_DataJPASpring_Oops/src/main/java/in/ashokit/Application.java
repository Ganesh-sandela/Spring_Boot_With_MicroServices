package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.Entity.User;
import in.ashokit.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService user = context.getBean(UserService.class);
		
//		user.saveuser();
//		
//		user.deleteall();
//		
//		user.savealluser();
		
//		user.finallusers();
		
//		user.getuserbyid(102);
		
//		user.usercount();
		
//		user.usrdeletebyid(12);
			
//		user.usrlistdelete();
		
//		user.getusrcountry("america");
		
//		user.getusrcountryandgender("america", "female");
		
//		user.getname("mamatha");
		
//		user.getSQL();
		
		user.getHQL();
		
		
		
		
	}

}
