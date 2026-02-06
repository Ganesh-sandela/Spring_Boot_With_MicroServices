package in.ashokit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Contact;
import in.ashokit.Entity.Person;
import in.ashokit.repo.ContactRepo;
import in.ashokit.repo.PersonRepo;
import jakarta.transaction.Transactional;
@Service
public class TxService {
	@Autowired
	private ContactRepo crepo;
	@Autowired
	private PersonRepo prepo;
	@Transactional(rollbackOn =Exception.class)
	public void PersonWithContact() {
		Person p= new Person();
		p.setName("ABC");
		p.setAge(22);
		p.setGender("male");
		p.setCountry("ind");
		prepo.save(p);
		
		int i=10/0;
		
		Contact c= new Contact();
		c.setName("gana");
		c.setEmail("gana@gmail.com");
		c.setPhno(1234567896);
		crepo.save(c);
	}

}
