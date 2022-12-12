package com.julius.petclinic.services.map;

import com.julius.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    Owner owner;

    Long ownerId = 125L;
    String ownerLastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(ownerLastName);

        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertNotNull(owners);
        assertEquals(1, owners.size());
    }

    @Test
    void saveExistingId() {
        Owner o2 = new Owner();
        o2.setId(222L);
        o2.setLastName("Test123");

        ownerMapService.save(o2);

        assertNotNull(ownerMapService.map);
        assertEquals(2, ownerMapService.map.size());
        assertEquals(ownerId, ownerMapService.map.get(ownerId).getId());
    }

    @Test
    void saveNewId() {
        Long secondId = 333L;
        Owner o2 = new Owner();
        o2.setId(secondId);
        o2.setLastName("Test123");

        Owner savedOwner = ownerMapService.save(o2);

        assertNotNull(ownerMapService.map);
        assertEquals(2, ownerMapService.map.size());
        assertEquals(secondId, ownerMapService.map.get(secondId).getId());
        assertEquals(secondId, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner o2 = new Owner();
        Owner savedOwner = ownerMapService.save(o2);

        assertNotNull(ownerMapService.map);
        assertEquals(2, ownerMapService.map.size());
        assertEquals(o2.getId(), savedOwner.getId());
        assertNotNull(o2.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(owner);

        //assertEquals(0, ownerMapService.map.size());
        assertEquals(0, ownerMapService.findAll().size());

        Owner deletedOwner = ownerMapService.findById(owner.getId());
        assertNull(deletedOwner);
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.map.size());

        Owner deletedOwner = ownerMapService.findById(ownerId);
        assertNull(deletedOwner);
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertNotNull(owner);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findById_NotFound() {
        Owner findOwner = ownerMapService.findById(777L);

        assertNull(findOwner);
    }

    @Test
    void findByLastName() {
        Owner findOwner = ownerMapService.findByLastName(ownerLastName);

        assertNotNull(findOwner);
        assertEquals(ownerId, findOwner.getId());
        assertEquals(ownerLastName, findOwner.getLastName());
    }

    @Test
    void findByLastName_NotFound() {
        Owner findOwner = ownerMapService.findByLastName("we7ufvewkscuwe");

        assertNull(findOwner);
    }
}