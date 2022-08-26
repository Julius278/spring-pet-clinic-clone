package com.julius.petclinic.model;

public class Vet extends Person{

    @Override
    public String toString(){
        return "[Vet: {"+"id: "+getId() +", firstName: "+getFirstName()+", lastName: "+getLastName()+"}]";
    }
}
