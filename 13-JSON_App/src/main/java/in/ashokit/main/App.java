package in.ashokit.main;

import java.io.File;
import java.lang.runtime.ObjectMethods;

import in.ashokit.binding.Customer;
import tools.jackson.databind.ObjectMapper;

public class App {
	
	
	public static void main(String[] args) {
		App a= new App();
		a.covertjavatojson();
		a.convertJsonToJava();
	}
	
	public void convertJsonToJava() {
		//De_Sirialization
		File f= new File("customer.json");
		ObjectMapper om= new ObjectMapper();
		Customer value = om.readValue(f, Customer.class);
		System.out.println(value);
	}
	
	public void  covertjavatojson() {
		//seialization
		File f =new File("customer.json");
		Customer c= new Customer();
		c.setCid(1);
		c.setName("ganesh");
		c.setPhno("9581288259");
		
		ObjectMapper om=new ObjectMapper();
		om.writeValue(f,c);
		System.out.println("operation completed...");
	}

}
