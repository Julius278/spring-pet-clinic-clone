package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;
    Long petId = 133L;

    @BeforeEach
    void setUp(){
        pet = new Pet();
        pet.setId(petId);
    }

    @Test
    void getName() {
        String name = "Fluffy";

        pet.setName(name);

        assertEquals(pet.getName(), name);
    }

    @Test
    void getPetType() {
        PetType petType = new PetType();
        petType.setId(124L);

        pet.setPetType(petType);

        assertEquals(pet.getPetType(), petType);
    }

    @Test
    void getOwner() {
        Long ownerId = 22L;
        Owner owner = new Owner();
        owner.setId(ownerId);

        pet.setOwner(owner);

        assertNotNull(pet.getOwner());
        assertNotNull(pet.getOwner().getId());
        assertEquals(pet.getOwner(), owner);
    }

    @Test
    void getBirthDate() {
        LocalDate birthDate = LocalDate.of(2000, 8, 12);
        pet.setBirthDate(birthDate);

        assertEquals(pet.getBirthDate(), birthDate);
    }

    @Test
    void getVisits() {
        Visit visit = new Visit();
        visit.setId(1L);
        Set<Visit> visits = new HashSet<>();
        visits.add(visit);

        pet.setVisits(visits);

        assertNotNull(pet.getVisits());
        assertEquals(pet.getVisits(), visits);
    }

    @Test
    void getAddedVisit() {
        Long visitId = 123L;

        Visit visit = new Visit();
        visit.setId(visitId);

        pet.addVisit(visit);

        assertNotNull(pet.getVisits());
        assertTrue(pet.getVisits().size() > 0);

        Visit addedVisit = new Visit();
        for (Visit v: pet.getVisits()) {
            if(v.getId().equals(visitId)){
                addedVisit = v;
            }
        }
        assertNotNull(addedVisit);
        assertEquals(addedVisit.getId(), visitId);

        assertNotNull(addedVisit.getPet());
        System.out.println(addedVisit.getPet());
        assertEquals(addedVisit.getPet().getId(), petId);
    }
}