package in.ashokit.Entity;

import java.util.List;

import org.hibernate.annotations.Fetch;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Employee {
    @ Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String ename;
	private double salary;
	
	@OneToMany(cascade = CascadeType.ALL,
			mappedBy = "emp",
		fetch = FetchType.EAGER
			)
	private List<Address> addr;
}
