package epicode.JAVASPRINGWEEK6DAY3.repositories;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import epicode.JAVASPRINGWEEK6DAY3.entities.Postazione;
import epicode.JAVASPRINGWEEK6DAY3.entities.Prenotazione;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {
	Optional<Prenotazione> findByPostazioneAndDataPrenotata(Postazione postazione, LocalDate data);
}
