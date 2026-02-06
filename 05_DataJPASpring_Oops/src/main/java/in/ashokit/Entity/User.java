package in.ashokit.Entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usertb")
public class User {
   @Id
	private Integer id;
	private String name;
	private String gender;
	private String country;
	
	@CreationTimestamp
	private LocalDate createdate;
    
	@UpdateTimestamp
	private LocalDate lastupdatedate;

}
