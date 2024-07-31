package com.example.pubcsm.repository;

import com.example.pubcsm.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // Metodi personalizzati possono essere aggiunti qui se necessario
}
