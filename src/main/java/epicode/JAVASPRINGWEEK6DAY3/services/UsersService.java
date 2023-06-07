package epicode.JAVASPRINGWEEK6DAY3.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import epicode.JAVASPRINGWEEK6DAY3.entities.User;
import epicode.JAVASPRINGWEEK6DAY3.exceptions.NotFoundException;
import epicode.JAVASPRINGWEEK6DAY3.repositories.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepo;

	public User findById(UUID id) throws NotFoundException {
		return usersRepo.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato!"));
	}
}
