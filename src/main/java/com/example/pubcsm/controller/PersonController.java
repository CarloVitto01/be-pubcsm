package com.example.pubcsm.controller;

import com.example.pubcsm.dto.PersonDTO;
import com.example.pubcsm.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Operation(summary = "Create a new person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Person created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {
        PersonDTO createdPerson = personService.createPerson(personDTO);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a person by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long id) {
        PersonDTO personDTO = personService.getPersonById(id);
        return new ResponseEntity<>(personDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get all persons")
    @ApiResponse(responseCode = "200", description = "List of persons")
    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        List<PersonDTO> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @Operation(summary = "Update a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Person updated successfully"),
            @ApiResponse(responseCode = "404", description = "Person not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        PersonDTO updatedPerson = personService.updatePerson(id, personDTO);
        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @Operation(summary = "Delete a person by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Person deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
