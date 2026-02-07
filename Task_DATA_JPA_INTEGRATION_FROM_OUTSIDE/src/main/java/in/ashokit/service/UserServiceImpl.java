package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import in.ashokit.entity.User;
import in.ashokit.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository urepo;
	
	@Override
	public String saveuser( User u) {
		User save = urepo.save(u);
		return "saved...";
	}

	@Override
	public List<User> getall() {
List<User> all = urepo.findAll();
		return all;
	}

	@Override
	public User getbyid(Integer id) {
       Optional<User> byId = urepo.findById(id);
       if (byId.isPresent()) {
		User user = byId.get();
		return user;
	}
		return null;
	}

	@Override
	public String deletebyid(Integer id) {
	  Optional<User> byId = urepo.findById(id);
	  if (byId.isPresent()) {
		   urepo.deleteById(id);
		   return"succesfully deletd...";
	}
		return "invalid id...";
	}

}
