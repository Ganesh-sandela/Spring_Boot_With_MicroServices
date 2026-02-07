package in.ashokit.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Customer;
import in.ashokit.repo.CustomerRepo;
@Service
public class CustomerService implements UserDetailsService {
	@Autowired
	private BCryptPasswordEncoder pwdencode;
	
	@Autowired
	private CustomerRepo crepo;

	
	public Boolean save( Customer c) {
		
		String encode = pwdencode.encode(c.getPwd());
		c.setPwd(encode);
		
		Customer save = crepo.save(c);
		return save.getCid()!=null;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Customer c = crepo.findByEmail(email);
		return  new User(c.getEmail(), c.getPwd(),Collections.EMPTY_LIST);
	}
	
	
}
