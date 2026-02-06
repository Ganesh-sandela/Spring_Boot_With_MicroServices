package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Employee;

public interface Emprepo extends JpaRepository<Employee, Integer> {

}
