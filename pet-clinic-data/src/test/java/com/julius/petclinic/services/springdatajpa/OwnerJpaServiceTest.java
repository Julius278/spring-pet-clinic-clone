package com.julius.petclinic.services.springdatajpa;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.repositories.OwnerRepository;
import com.julius.petclinic.repositories.PetRepository;
import com.julius.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService service;

    Owner returnOwner;
    Long saveId;
    String lastName;

    @BeforeEach
    void setUp() {
        saveId = 1234L;
        lastName = "Wurst";

        returnOwner = new Owner();
        returnOwner.setId(saveId);
        returnOwner.setLastName(lastName);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwners = new HashSet<>();

        returnOwners.add(returnOwner);

        Owner o2 = new Owner();
        o2.setId(234L);
        o2.setLastName("Test234");

        returnOwners.add(o2);

        when(ownerRepository.findAll()).thenReturn(returnOwners);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(owners.size(), returnOwners.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(saveId);

        assertEquals(owner.getId(), saveId);
        verify(ownerRepository, times(1)).findById(anyLong());
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {

        when(ownerRepository.findById(any())).thenReturn(Optional.empty());

        Owner owner = service.findById(saveId);

        verify(ownerRepository, times(1)).findById(anyLong());
        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner saveOwner = new Owner();
        saveOwner.setId(saveId);

        Owner savedOwner = service.save(saveOwner);

        assertNotNull(savedOwner);
        assertEquals(savedOwner.getId(), saveId);
        verify(ownerRepository, times(1)).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(saveId);
        verify(ownerRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findByLastName(lastName);

        assertEquals(owner.getLastName(), lastName);
        verify(ownerRepository, times(1)).findByLastName(any());
    }

    @Test
    void findByLastNameNotFound() {
        when(ownerRepository.findByLastName(any())).thenReturn(Optional.empty());

        Owner owner = service.findByLastName(lastName);

        assertNull(owner);
        verify(ownerRepository, times(1)).findByLastName(any());
    }
}