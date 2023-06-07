package epicode.JAVASPRINGWEEK6DAY3.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import epicode.JAVASPRINGWEEK6DAY3.entities.Prenotazione;
import epicode.JAVASPRINGWEEK6DAY3.entities.payloads.PrenotazioneRegistrationPayload;
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

	@PostMapping("")
	public Prenotazione createPrenotazione(@RequestBody PrenotazioneRegistrationPayload body) {

		return prenotazioniService.create(body);
	}

	@PutMapping("/{prenotazioneId}")
	public Prenotazione updatePrenotazione(@PathVariable UUID prenotazioneId,
			@RequestBody PrenotazioneRegistrationPayload body) {
		return prenotazioniService.findByIdAndUpdate(prenotazioneId, body);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePrenotazione(@PathVariable UUID id) {
		prenotazioniService.findByIdAndDelete(id);
	}

}
