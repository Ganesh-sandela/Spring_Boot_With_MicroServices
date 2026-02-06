package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
