package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
import in.ashokit.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserRestController {

    private final UserRepository userRepository;
	
	
	@Autowired
	private UserService user;


    UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	
	@PostMapping("/user")
	public ResponseEntity<String> upsert(@RequestBody User u){
		
		String status = user.saveuser(u);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getall(){
		  List<User> getall = user.getall();
		  return  new ResponseEntity<List<User>>(getall,HttpStatus.OK);
	}
	
	@PutMapping("user")
    public ResponseEntity<String> update(@RequestBody User u){
		
		String status = user.saveuser(u);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable Integer id){
		
		String status = user.deletebyid(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
	
}
