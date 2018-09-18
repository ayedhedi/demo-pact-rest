package com.example.demospringpact.rest;

import com.example.demospringpact.model.Person;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping("/persons")
@CrossOrigin(origins = "*")
public class PersonController {

    private static final Map<Long, Person> persons = new HashMap<>();

    @PostConstruct
    public void init(){
        persons.put(1L, Person.builder().id(1L).age(10).name("Jack").build());
    }

    @GetMapping
    public ResponseEntity<Collection<Person>> getPersons(){
        return ResponseEntity.ok(persons.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable long id){

        return Optional.ofNullable(persons.get(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person){

        if (person.getId() == null) {
            person.setId((long)(Math.random()*100000));
        }

        persons.put(person.getId(), person);
        return ResponseEntity.ok(person);
    }
}
