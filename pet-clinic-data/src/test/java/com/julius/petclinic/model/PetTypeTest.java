package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTypeTest {

    PetType petType;
    String name;

    @BeforeEach
    void setUp() {
        name = "Dachs";

        petType = new PetType();
        petType.setId(123L);
        petType.setName(name);
    }

    @Test
    void getName() {
        assertEquals(petType.getName(), name);
    }
}