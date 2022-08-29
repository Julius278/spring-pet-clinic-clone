package com.julius.petclinic.services;

import com.julius.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long>{
    Vet findByLastName(String lastName);
}