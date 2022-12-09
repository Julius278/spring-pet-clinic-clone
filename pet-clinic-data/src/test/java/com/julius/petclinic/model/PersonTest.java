package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;
    String firstName, lastName;

    @BeforeEach
    void setUp() {
        person = new Person();
        firstName = "Hans";
        lastName = "Wurst";
        person.setId(1L);
        person.setFirstName(firstName);
        person.setLastName(lastName);
    }

    @Test
    void getFirstName() {
        assertEquals(person.getFirstName(), firstName);
    }

    @Test
    void getLastName() {
        assertEquals(person.getLastName(), lastName);
    }
}