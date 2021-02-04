package com.store.service.impl;

import com.store.dto.request.PersonRequest;
import com.store.dto.response.PersonResponse;
import com.store.mapper.PersonMapper;
import com.store.model.Person;
import com.store.repository.PersonRepository;
import com.store.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonResponse createPerson(PersonRequest personRequest) {
        if(personRequest != null) {
            Person person = personMapper.requestToEntity(personRequest);
            personRepository.save(person);
            return personMapper.toDtoEntity(person);
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public List<PersonResponse> getAllPersons() {
        List<Person> all = personRepository.findAll();
        return all.stream().map(personMapper::toDtoEntity).collect(Collectors.toList());
    }

    @Override
    public PersonResponse updatePerson(Long id, PersonRequest personRequest) {
        Person one = personRepository.getOne(id);
        Person person = personMapper.requestToEntity(personRequest, one);
        Person save = personRepository.save(person);
        return personMapper.toDtoEntity(save);
    }

    @Override
    public void removePerson(Long id) {
        personRepository.deleteById(id);
    }
}
