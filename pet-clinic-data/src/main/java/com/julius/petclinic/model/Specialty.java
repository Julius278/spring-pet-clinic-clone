package com.julius.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Override
    public String toString(){
        return "[VetSpecialty: {"+"id: " + getId() + ", description: " + getDescription() + "}]";
    }
}
