package com.julius.petclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"owner", "visits"})
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();

	public void addVisit(Visit visit) {
		visit.setPet(this);
		this.visits.add(visit);
	}

	@Override
	public String toString(){
		return "[Pet: {"+"id: "+getId()+", name: "+getName() +", petType: "+getPetType()+", Birthdate: "+getBirthDate()+"}]";
	}
}
