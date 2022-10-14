package com.julius.petclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"pets"})
@EqualsAndHashCode(exclude = {"pets"})
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String City;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    /*
    @Override
    public String toString() {
        return "[Owner: {"+"id: "+getId() +", firstName: " + getFirstName() +", lastName:" + getLastName()+", city: "+getCity()+", address: "+getAddress()+", telephone: "+getTelephone()+"}]";
    }*/
}
