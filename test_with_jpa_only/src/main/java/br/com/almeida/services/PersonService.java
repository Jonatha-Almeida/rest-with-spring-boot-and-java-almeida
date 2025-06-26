package br.com.almeida.services;

import br.com.almeida.model.Person;
import br.com.almeida.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        logger.info("PersonService ~> Fetching all persons");
        return this.personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("PersonService ~> Fetching one person by ID " + id);
        return this.personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot found person with ID " + id));
    }

}
