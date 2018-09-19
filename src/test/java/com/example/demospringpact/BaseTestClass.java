package com.example.demospringpact;


import com.example.demospringpact.model.Person;
import com.example.demospringpact.rest.PersonController;
import com.example.demospringpact.rest.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public class BaseTestClass {

    @Mock
    private PersonService personService;

    @Before
    public void setup() {
        Mockito.when(personService.getPersons())
                .thenReturn(Collections.singleton(
                        Person.builder().name("stub").age(22).id(0L).build()));

        Mockito.when(personService.getPerson(1))
                .thenReturn(Person.builder().name("one").age(2).id(1L).build());

        StandaloneMockMvcBuilder standaloneMockMvcBuilder
                = MockMvcBuilders.standaloneSetup(new PersonController(personService));
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
    }
}