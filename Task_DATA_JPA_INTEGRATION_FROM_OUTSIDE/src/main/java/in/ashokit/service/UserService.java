package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
@Service
public interface UserService {

	public String saveuser(User u);
	
	public List<User> getall();
	
	public User getbyid(Integer id);
	
	public String deletebyid(Integer id);
}
