package in.ashokit.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.Entity.User;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	
	
	@Query(value = "select * from usertb",nativeQuery = true)
	public List<User> getusersSQL();
	
	//HQL Queries 
	
	@Query("From User")
	public List<User> getusersHQL();
	
//	@Query("Insert into Users values(4,'ABC','male','india')")
//	public User InsertHQL();
	
	
	

	//based on the country
	public  List<User> findByCountry(String country);
	  //based on the counntry and name
	public List<User> findByCountryAndGender(String country,String gender);
	
	//based on the name
	public List<User> findByName(String name);
}
