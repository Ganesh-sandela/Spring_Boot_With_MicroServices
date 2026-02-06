package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "this is mandatory name")
	private String name;
	@NotEmpty(message = "this is mandatory email")
	private String email;
	@NotEmpty(message = "Phone number is mandatory")
	@Pattern(regexp = "[0-9]{10}", message = "Phone must be 10 digits")
	private String phno;

	
	@CreationTimestamp
	@Column(updatable = false)//once the value shuld be inserted the value not chaneg
	private LocalDate createdat;
	@UpdateTimestamp
	@Column(insertable = false)// when the first time recrd should inseretd 
	private LocalDate updateat;//this clum value should not be populted
	
}
