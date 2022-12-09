package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetTest {

    Vet vet;

    @BeforeEach
    void setUp(){
        vet = new Vet();
        vet.setId(99L);
    }

    @Test
    void getSpecialties() {
        assertNotNull(vet.getSpecialties());

        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty = new Specialty();
        specialty.setId(12L);
        specialties.add(specialty);

        vet.setSpecialties(specialties);

        assertNotNull(vet.getSpecialties());
        assertEquals(vet.getSpecialties(), specialties);
    }
}