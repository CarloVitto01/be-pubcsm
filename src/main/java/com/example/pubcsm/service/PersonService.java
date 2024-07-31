package com.example.pubcsm.service;

import com.example.pubcsm.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO createPerson(PersonDTO personDTO);
    PersonDTO getPersonById(Long id);
    List<PersonDTO> getAllPersons();
    PersonDTO updatePerson(Long id, PersonDTO personDTO);
    void deletePerson(Long id);
}
