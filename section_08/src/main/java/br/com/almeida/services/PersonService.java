package br.com.almeida.services;

import br.com.almeida.exceptions.ResourceNotFoundException;
import br.com.almeida.model.Person;
import br.com.almeida.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("PersonService ~> Fetching all persons");
        return this.repository.findAll();

    }

    public Person findById(Long id) {
        logger.info("PersonService ~> Fetching one person by ID " + id);
        Person person = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person");
        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public Person update(Person person){
        logger.info("update one person");
        Person entity = this.repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));

        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("delete one person");
        Person person = this.repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this id!"));
        this.repository.delete(person);
    }

}
