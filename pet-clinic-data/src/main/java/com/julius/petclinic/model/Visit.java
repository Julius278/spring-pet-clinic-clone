package com.julius.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"pet"})
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Visit(LocalDate date, String description){
        this.date = date;
        this.description = description;
    }

    public Visit(){}

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "[Visit: {"+"id: "+getId() +", description: "+getDescription()+", pet: "+getPet()+", time: "+getDate()+"}]";
    }
}
