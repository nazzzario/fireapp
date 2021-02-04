package com.store.controller;

import com.store.dto.request.PersonRequest;
import com.store.dto.response.PersonResponse;
import com.store.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponse createPerson(@RequestBody PersonRequest personRequest) {
        return personService.createPerson(personRequest);
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public PersonResponse updatePerson(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        return personService.updatePerson(id, personRequest);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable Long id) {
        personService.removePerson(id);
    }
}
