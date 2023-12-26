package com.practiceproject.webshop.repointerface;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceproject.webshop.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	Optional<Person> findByUsername(String username);
}
