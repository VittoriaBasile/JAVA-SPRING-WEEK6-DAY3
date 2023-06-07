package epicode.JAVASPRINGWEEK6DAY3.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private UUID id;
	private String username;
	private String nome;
	private String email;
	private Boolean active = true;

	private String password;

}
