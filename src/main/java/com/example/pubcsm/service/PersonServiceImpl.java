package com.example.pubcsm.service;

import com.example.pubcsm.dto.PersonDTO;
import com.example.pubcsm.model.Person;
import com.example.pubcsm.mapper.PersonMapper;
import com.example.pubcsm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonDTO createPerson(PersonDTO personDTO) {
        Person person = personMapper.toEntity(personDTO);
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    }

    @Override
    public PersonDTO getPersonById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return personMapper.toDTO(person);
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return personRepository.findAll().stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found"));
        person.setName(personDTO.getName());
        person = personRepository.save(person);
        return personMapper.toDTO(person);
    }

    @Override
    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person not found");
        }
        personRepository.deleteById(id);
    }
}
