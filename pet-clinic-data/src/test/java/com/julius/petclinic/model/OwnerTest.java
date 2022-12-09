package com.julius.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    Owner owner;

    @BeforeEach
    void setUp(){
        owner = new Owner();
    }

    @Test
    void getId(){
        Long id = 123L;
        owner.setId(id);

        assertEquals(owner.getId(), id);
    }

    @Test
    void getAddress() {
        String address = "sample street 4";
        owner.setAddress(address);

        assertEquals(owner.getAddress(), address);
    }

    @Test
    void getCity() {
        String c = "gotham";
        owner.setCity(c);

        assertEquals(owner.getCity(), c);
    }

    @Test
    void getTelephone() {
        String t = "012222222";
        owner.setTelephone(t);

        assertEquals(owner.getTelephone(), t);
    }

    @Test
    void getPets() {
        Set<Pet> pets = new HashSet<>();
        Pet p1 = new Pet();
        p1.setId(55L);
        pets.add(p1);

        owner.setPets(pets);

        assertEquals(owner.getPets(), pets);
    }
}