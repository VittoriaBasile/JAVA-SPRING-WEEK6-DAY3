package epicode.JAVASPRINGWEEK6DAY3.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
public class Prenotazione {

	@Id
	@GeneratedValue
	private UUID id;

	@ManyToOne
	@NonNull
	private User user;

	@ManyToOne
	@NonNull
	private Postazione postazione;

	@NonNull
	private LocalDate dataPrenotata;

	private LocalDate dataPrenotazione;

	public Prenotazione(User user, Postazione postazione, LocalDate dataPrenotata, LocalDate dataPrenotazione) {
		this.user = user;
		this.postazione = postazione;
		this.dataPrenotata = dataPrenotata;
		this.dataPrenotazione = dataPrenotazione;
	}

}
