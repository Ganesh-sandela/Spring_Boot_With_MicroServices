package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;
import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {

    private final SecurityFilterChain security;

    private final CustomerRepo customerRepo;

	@Autowired
	private AuthenticationManager authmanager;

	@Autowired
	private CustomerService cserv;


    CustomerRestController(CustomerRepo customerRepo, SecurityFilterChain security) {
        this.customerRepo = customerRepo;
        this.security = security;
    }

	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer c){
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());
		//verify login details valid or not
		  Authentication authenticate = authmanager.authenticate(token);
		  
		  boolean status = authenticate.isAuthenticated();
		 if (status) {
			return new ResponseEntity<String>("succes",HttpStatus.OK);
		}
		 else {
			 return new ResponseEntity<String>("failed",HttpStatus.BAD_REQUEST);
		 }
	}
   
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer c){
		Boolean status = cserv.save(c);
		
		if (status) {
			return new  ResponseEntity<String>("success",HttpStatus.CREATED);
		}
		else {
			return new  ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
