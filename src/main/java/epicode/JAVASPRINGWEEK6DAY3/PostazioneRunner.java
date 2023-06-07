package epicode.JAVASPRINGWEEK6DAY3;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import epicode.JAVASPRINGWEEK6DAY3.entities.Edificio;
import epicode.JAVASPRINGWEEK6DAY3.entities.Postazione;
import epicode.JAVASPRINGWEEK6DAY3.entities.TipoPostazione;
import epicode.JAVASPRINGWEEK6DAY3.repositories.EdificiRepository;
import epicode.JAVASPRINGWEEK6DAY3.repositories.PostazioniRepository;

@Component
public class PostazioneRunner implements CommandLineRunner {
	@Autowired
	PostazioniRepository postazioniRepo;
	@Autowired
	EdificiRepository edificiRepo;

	@Override
	public void run(String... args) throws Exception {
		Faker faker = new Faker(new Locale("it"));
		List<Postazione> postazioniDB = postazioniRepo.findAll();
		List<Edificio> edificiDB = edificiRepo.findAll();

		if (postazioniDB.size() == 0) {
			for (int i = 0; i < 20; i++) {
				try {

					String descrizione = faker.lorem().sentence();
					int numeroMassimo = faker.number().numberBetween(1, 10);
					int randomIndex = new Random().nextInt(edificiDB.size());
					Edificio randomEdifici = edificiDB.get(randomIndex);

					int randomTipopostazione = new Random().nextInt(TipoPostazione.values().length);
					TipoPostazione tipo = TipoPostazione.values()[randomTipopostazione];
					Postazione postazione = new Postazione(descrizione, numeroMassimo, tipo, randomEdifici);
					postazioniRepo.save(postazione);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
