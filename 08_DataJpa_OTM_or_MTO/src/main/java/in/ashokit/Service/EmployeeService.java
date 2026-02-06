package in.ashokit.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Address;
import in.ashokit.Entity.Employee;
import in.ashokit.repo.Addrrepo;
import in.ashokit.repo.Emprepo;
import jakarta.transaction.Transactional;
@Service
public class EmployeeService {

	@Autowired
	private Emprepo erepo;
	@Autowired
	private Addrrepo arepo;
	
	public void getEmp() {
		Optional<Employee> byId = erepo.findById(3);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}
	@Transactional
	public void Adelete() {
		erepo.deleteById(3);
	}
	public void saveEmpWithAddr() {
		Employee e=new Employee();
		e.setEname("ganesh");
		e.setSalary(50000.0);
		
		Address a= new Address();
		a.setCity("vlp");
		a.setState("telanagana");
		a.setType("present");
		
		
		Address a1= new Address();
		a1.setCity("jgl");
		a1.setState("telanagana");
		a1.setType("future");
		
		Address a2= new Address();
		a2.setCity("mdpl");
		a2.setState("telanagana");
		a2.setType("present");
		List<Address> list = Arrays.asList(a,a1,a2);
		a.setEmp(e);
		a1.setEmp(e);
		a2.setEmp(e);
		e.setAddr(list);
		
		erepo.save(e);
		
	
	}
}
