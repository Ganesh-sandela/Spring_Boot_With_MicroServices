package in.ashokit.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Person;
import in.ashokit.repo.PersonRepo;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepo prepo;
	
	
	//sorting in jparepository
	public void getsort() {
		Sort descending = Sort.by("age").descending(); // or ascending();
		List<Person> all = prepo.findAll(descending);
		all.forEach(System.out::println);
	}
	//pagination in jparepository
	public void getpagination() {
		int pagesize=3;
		int pageno=3;
		
		PageRequest of = PageRequest.of(pageno-1, pagesize);
		Page<Person> all = prepo.findAll(of);
		List<Person> content = all.getContent();
		content.forEach(System.out::println);
	}
	 
	//QBE(Query By Example) in jparepository;
	public void getQBE(String gender,String country) {
		Person p= new Person();
		if (gender!=null) {
			p.setGender(gender);
			
		}
		if (country!=null) {
			p.setCountry(country);
		}
		ExampleMatcher withIgnoreCase = ExampleMatcher.matching().withIgnorePaths("age","id").withIgnoreCase();
		Example<Person> of = Example.of(p,withIgnoreCase);
		List<Person> all = prepo.findAll(of);
		all.forEach(System.out::println);
	}
	
	public void saveuser() {
		Person p1= new Person(9,"Ganesh",22,"male","india");
		Person p2= new Person(2,"mamatha",21,"female","uk");
		Person p3= new Person(3,"mahesh",19,"male","america");
		Person p4= new Person(4,"soni",20,"female","london");
		Person p5= new Person(5,"anand",22,"male","usa");
		Person p6= new Person(6,"gaman",24,"male","singapore");
		Person p7= new Person(7,"sai",22,"male","india");
		Person p8= new Person(8,"mama",20,"female","america");
		Person p9= new Person(1,"harish",24,"male","india");
		List<Person> asList = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9);
		prepo.saveAll(asList);
	}

}
