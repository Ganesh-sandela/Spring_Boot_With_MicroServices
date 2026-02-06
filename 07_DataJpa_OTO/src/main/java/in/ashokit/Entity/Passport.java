package in.ashokit.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pass_id;
	private String passno;
	private LocalDate issuedate;
	private LocalDate expireddate;
	
	@OneToOne
	@JoinColumn(name = "person_id")
	private Person person;
	

	
}
