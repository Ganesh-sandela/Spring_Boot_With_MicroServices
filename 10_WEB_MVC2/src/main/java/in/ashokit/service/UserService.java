package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.User;

public interface UserService {
	
	public Boolean save(User user);
	
	public List<User> getall();
 
	public void delete(Integer id);
	
	public Boolean edituser(User user);
	
	public  User get(Integer id);
}
