package com.example.pubcsm.mapper;

import com.example.pubcsm.dto.PersonDTO;
import com.example.pubcsm.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public PersonDTO toDTO(Person person) {
        if (person == null) {
            return null;
        }

        PersonDTO dto = new PersonDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        return dto;
    }

    public Person toEntity(PersonDTO personDTO) {
        if (personDTO == null) {
            return null;
        }

        Person person = new Person();
        person.setId(personDTO.getId());
        person.setName(personDTO.getName());
        return person;
    }
}