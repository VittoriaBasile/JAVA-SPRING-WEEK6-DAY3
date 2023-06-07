package epicode.JAVASPRINGWEEK6DAY3.entities.payloads;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PrenotazioneRegistrationPayload {

	@NotNull(message = "L' utente è obbligatorio")
	UUID userId;
	@NotNull(message = "La postazione è obbligatoria")
	UUID postazioneId;
	@NotNull(message = "La data della prenotazione è obbligatoria")
	LocalDate dataPrenotata;
}
