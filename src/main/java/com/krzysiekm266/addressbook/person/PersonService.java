package com.krzysiekm266.addressbook.person;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krzysiekm266.addressbook.person.exceptions.PersonIllegalStateException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private PersonRepository personRepository;

    public List<Person> personFindAll() {
        return this.personRepository.findAll();
    }

    public Optional<Person> personFindById(Long id) {
        return this.personRepository.findById(id);
    }

    public Person personAdd(Person person) {
        return this.personRepository.save(person);
    }

    public Person personUpdate(Long id) {
       Person person = this.personFindById(id).orElseThrow( () -> new PersonIllegalStateException("Person by Id:"+ id +" not found") );
       return person;
    }
    
    
}
