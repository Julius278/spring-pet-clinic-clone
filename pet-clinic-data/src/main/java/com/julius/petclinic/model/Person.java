package com.julius.petclinic.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public class Person extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Override
	public String toString() {
		return "[Person: {"+"id: "+getId() +", firstName: " + firstName +", lastName:" + lastName +"}]";
	}
}
