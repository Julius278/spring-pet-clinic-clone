package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VisitTest {

    Visit visit, visitFull;
    LocalDate date;
    String description;

    @BeforeEach
    void setUp() {
        date = LocalDate.now();
        description = "test description";
        visitFull = new Visit(date, description);

        visit = new Visit();
    }

    @Test
    void getDate() {
        assertEquals(date, visitFull.getDate());
        assertNull(visit.getDate());

        visit.setDate(date);

        assertNotNull(visit.getDate());
        assertEquals(date, visit.getDate());
    }

    @Test
    void getDescription() {
        assertEquals(description, visitFull.getDescription());
        assertNull(visit.getDescription());

        visit.setDescription(description);

        assertNotNull(visit.getDescription());
        assertEquals(description, visit.getDescription());
    }

    @Test
    void getPet() {
        Pet pet = new Pet();
        visit.setPet(pet);

        assertNotNull(visit.getPet());
        assertEquals(pet, visit.getPet());
    }
}