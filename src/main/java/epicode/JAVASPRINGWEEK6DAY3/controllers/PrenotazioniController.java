package epicode.JAVASPRINGWEEK6DAY3.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import epicode.JAVASPRINGWEEK6DAY3.entities.Prenotazione;
import epicode.JAVASPRINGWEEK6DAY3.services.PrenotazioniService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {
	@Autowired
	private PrenotazioniService prenotazioniService;

	@GetMapping("")
	public Page<Prenotazione> getPrenotazione(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return prenotazioniService.find(page, size, sortBy);
	}

	@GetMapping("/{prenotazioneId}")
	public Prenotazione getPrenotazione(@PathVariable UUID prenotazioneId) throws Exception {
		return prenotazioniService.findById(prenotazioneId);
	}

}