package com.example.demospringpact.rest;

import com.example.demospringpact.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<Collection<Person>> getPersons(){
        return ResponseEntity.ok(personService.getPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id){
        return Optional.ofNullable(personService.getPerson(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person){
        return ResponseEntity.ok(personService.savePerson(person));
    }
}
