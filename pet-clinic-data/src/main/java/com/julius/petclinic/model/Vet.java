package com.julius.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString(){
        return "[Vet: {"+"id: "+getId() +", firstName: "+getFirstName()+", lastName: "+getLastName()+"}]";
    }
}
