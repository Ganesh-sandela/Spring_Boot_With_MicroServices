package in.ashokit.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.Entity.User;
import in.ashokit.repo.UserRepository;
@Service
public class UserService {
private UserRepository urepo;

public UserService( UserRepository urepo) {
	this.urepo=urepo;
}


public void usrlistdelete() {
	
	urepo.deleteAll();
	System.out.println("table ahs deleted ");
}
public void getuserbyid(Integer uid) {
	Optional<User> byId = urepo.findById(uid);
	if (byId.isPresent()) {
		System.out.println(byId);
	}
	else {
		System.out.println("record notfound.....");
	}
}

public void usercount() {
	long count = urepo.count();
	System.out.println(count);
	
}

public void usrdeletebyid(Integer uid) {
	Optional<User> byId = urepo.findById(uid);
	if (byId.isPresent()) {
		urepo.deleteById(uid);
		System.err.println("succesfull deletd...");
	} else {
		System.out.println("not have recrd to delete..");

	}
}
public void finallusers() {
	Iterable<User> all = urepo.findAll();
	all.forEach(u->{
		System.out.println(u);
	});
}
public void deleteall() {
	urepo.deleteAll();
}

public void saveuser() {
	User u= new User();
	u.setId(101);
	u.setName("ganesh");
	u.setGender("male");
	u.setCountry("India");
	urepo.save(u); 
		
}

public void savealluser() {
	User u1= new User();
	u1.setId(1);
	u1.setName("anand");
	u1.setGender("male");
	u1.setCountry("uk");
	
	
	User u2= new User();
	u2.setId(2);
	u2.setName("mamatha");
	u2.setGender("female");
	u2.setCountry("america");
	
	User u3= new User();
	u3.setId(3);
	u3.setName("karthik");
	u3.setGender("male");
	u3.setCountry("uk");
	
	
	List<User> list = Arrays.asList(u1,u2,u3);
	
	urepo.saveAll(list);
}

public void getusrcountry( String country) {
	 List<User> byCountry = urepo.findByCountry(country);
	 byCountry.forEach(System.out::println);
}


public void getusrcountryandgender( String country,String gender) {
	 List<User> c = urepo.findByCountryAndGender(country,gender);
	 c.forEach(System.out::println);
}

public void getname(String name) {
	List<User> byName = urepo.findByName(name);
	byName.forEach(System.out::println);
	
}

public void getHQL() {
	List<User> hql = urepo.getusersHQL();
	hql.forEach(System.out::println);
}

public void getSQL() {
	List<User> sql = urepo.getusersSQL();
	sql.forEach(System.out::println);
}

}
