package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepo;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserRepo urepo;

	 @Override
	    public Boolean save(User user) {
	        User save = urepo.save(user);
	        return save.getId() != null;
	    }

	@Override
	public List<User> getall() {
	
		return urepo.findAll();
	}

	@Override
	public void delete(Integer id) {
		
		urepo.deleteById(id);
//		if (urepo.existsById(id)) {
//			urepo.deleteById(id);
//			return true;
//		} else {
//            return false;
//		}
	}

	@Override
	public Boolean edituser(User user) {
	    if (user.getId()!=null&& urepo.existsById(user.getId())) {
			urepo.save(user);
			return true;
		} else {
             return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public User get(Integer id) {
             User byId = urepo.getById(id);
             
		return byId;
	}

}
