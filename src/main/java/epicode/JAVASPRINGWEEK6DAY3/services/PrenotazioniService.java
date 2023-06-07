package epicode.JAVASPRINGWEEK6DAY3.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import epicode.JAVASPRINGWEEK6DAY3.entities.Prenotazione;
import epicode.JAVASPRINGWEEK6DAY3.exceptions.NotFoundException;
import epicode.JAVASPRINGWEEK6DAY3.repositories.PrenotazioniRepository;

@Service
public class PrenotazioniService {
	@Autowired
	private PrenotazioniRepository prenotazioniRepo;

//	public Prenotazione create(UserRegistrationPayload u) {
//		// TODO: check if email already exists
//		usersRepo.findByEmail(u.getEmail()).ifPresent(user -> {
//			throw new BadRequestException("Email " + user.getEmail() + " already in use!");
//		});
//		User newUser = new User(u.getName(), u.getSurname(), u.getEmail());
//		return usersRepo.save(newUser);
//	}
//
	public Page<Prenotazione> find(int page, int size, String sortBy) {
		if (size < 0)
			size = 10;
		if (size > 100)
			size = 100;
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

		return prenotazioniRepo.findAll(pageable);
	}

	public Prenotazione findById(UUID id) throws NotFoundException {
		return prenotazioniRepo.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata!"));
	}
//
//	public User findByIdAndUpdate(UUID id, User u) throws NotFoundException {
//		User found = this.findById(id);
//
//		found.setId(id);
//		found.setName(u.getName());
//		found.setSurname(u.getSurname());
//		found.setEmail(u.getEmail());
//
//		return usersRepo.save(found);
//	}
//
//	public void findByIdAndDelete(UUID id) throws NotFoundException {
//		User found = this.findById(id);
//		usersRepo.delete(found);
//	}

}
