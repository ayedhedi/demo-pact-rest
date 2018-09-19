package com.example.demospringpact.rest;

import com.example.demospringpact.model.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {


    private static final Map<Long, Person> persons = new HashMap<>();


    @PostConstruct
    public void init(){
        persons.put(1L, Person.builder().id(1L).age(10).name("Jack").build());
    }

    public Collection<Person> getPersons(){
        return persons.values();
    }

    public Person getPerson(final long id){
        return persons.get(id);
    }

    public Person savePerson(Person person){
        if (person.getId() == null){
            person.setId((long)(Math.random()*100000));
        }
        return persons.put(person.getId(), person);
    }

}
