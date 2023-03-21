package com.krzysiekm266.addressbook.person;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

/*endpoints
 * get - /persons
 * get - /persons/{personId}
 * post - /persons
 * put - /persons/{personId}
 * delete - /persons/{personId} 
 */
@RestController
@RequiredArgsConstructor
public class PersonController {
    private PersonService personService;

    @GetMapping(path = "/persons")
    public ResponseEntity<List<Person>> persons() {
        return new ResponseEntity<>(this.personService.personFindAll(),HttpStatus.OK);
    }

    @GetMapping(path = "/persons/{personId}")
    public ResponseEntity<Person> person(@PathParam(value = "personId") Long id) {
        return new ResponseEntity<>(this.personService.personFindById(id).get(),HttpStatus.OK);
    }

    @PostMapping(path = "/persons")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(this.personService.personAdd(person),HttpStatus.OK);
    }
}
