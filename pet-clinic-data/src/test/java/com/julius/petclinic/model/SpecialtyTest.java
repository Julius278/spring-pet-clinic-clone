package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyTest {

    Specialty specialty;
    String description;

    @BeforeEach
    void setUp() {
        description = "nice specialty";
        specialty = new Specialty();
        specialty.setId(19L);
        specialty.setDescription(description);
    }

    @Test
    void getDescription() {
        assertEquals(specialty.getDescription(), description);
    }
}