package in.ashokit.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Passport;
import in.ashokit.Entity.Person;
import in.ashokit.repo.PassportRepo;
import in.ashokit.repo.PersonRepo;

@Service
public class PersonPassportService {
	@Autowired
	private PersonRepo prepo;
	@Autowired
	private PassportRepo passrepo;
	
	
	public void save() {
		Person p= new Person();
		p.setName("Gana");
		p.setGender("male");
		
		Person person = prepo.save(p);
		
		Passport ps= new Passport();
		ps.setPassno("09876erfghjo");
		ps.setIssuedate(LocalDate.now());
		ps.setExpireddate(LocalDate.now().plusYears(10));
		
		ps.setPerson(person);
		
		Passport save = passrepo.save(ps);
		
		
	}
	
	public void getperson() {
		Optional<Person> byId = prepo.findById(1);
		if (byId.isPresent()) {
			System.out.println("..................."+byId.get());
		}
	}
	
	//left join to reterive data
	public void getpassport() {
		Optional<Passport> byId = passrepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
		
	
	
		
	}
	//delete person to try not deleytd becuse child table in have foregin key in child it 
			//voits constarint
		public void deleteperson() {
			prepo.deleteById(1);
		}
		
		//when we have parent and child relationship then we delete parent first it constrint voilates 
		//then delete child recrd in table and then delete agin in parent it dleted data
//we can delete child table record which is associated with parent table that has also deleted in parent recrd
		public void deletepassport() {
			passrepo.deleteById(1);
		}
}
            


