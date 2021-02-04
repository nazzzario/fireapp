package com.store.service;

import com.store.dto.request.PersonRequest;
import com.store.dto.response.PersonResponse;

import java.util.List;

public interface PersonService{
    PersonResponse createPerson(PersonRequest personRequest);

    List<PersonResponse> getAllPersons();

    PersonResponse updatePerson(Long id, PersonRequest personRequest);

    void removePerson(Long id);



}
