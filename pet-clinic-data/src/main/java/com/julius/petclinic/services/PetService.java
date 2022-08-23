package com.julius.petclinic.services;

import com.julius.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    //Pet findByOwnerId(Long ownerId);

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
