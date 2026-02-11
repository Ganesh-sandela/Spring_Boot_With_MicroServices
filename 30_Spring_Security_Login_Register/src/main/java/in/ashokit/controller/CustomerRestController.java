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
import in.ashokit.service.JwtService;

@RestController
public class CustomerRestController {

    private final SecurityFilterChain security;

    private final CustomerRepo customerRepo;

	@Autowired
	private AuthenticationManager authmanager;

	@Autowired
	private CustomerService cserv;
	
	@Autowired
	private JwtService jwtService;


    CustomerRestController(CustomerRepo customerRepo, SecurityFilterChain security) {
        this.customerRepo = customerRepo;
        this.security = security;
    }

	
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer c) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(c.getEmail(), c.getPwd());

        Authentication authenticate = authmanager.authenticate(token);

        if (authenticate.isAuthenticated()) {

            String jwt = jwtService.generateToken(c.getEmail());

            return ResponseEntity.ok(jwt);  // send token
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
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
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getwelcome(){
		return new ResponseEntity<String>("welcome to the page succesfully logged in...",HttpStatus.OK);
	}
}
