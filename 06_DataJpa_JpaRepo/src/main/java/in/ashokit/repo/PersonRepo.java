package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
