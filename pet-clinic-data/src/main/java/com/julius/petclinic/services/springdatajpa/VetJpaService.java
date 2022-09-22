package com.julius.petclinic.services.springdatajpa;

import com.julius.petclinic.model.Vet;
import com.julius.petclinic.repositories.SpecialtyRepository;
import com.julius.petclinic.repositories.VetRepository;
import com.julius.petclinic.services.SpecialtyService;
import com.julius.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetJpaService implements VetService {

    private final VetRepository vetRepository;
    private final SpecialtyRepository specialtyRepository;

    public VetJpaService(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
        this.vetRepository = vetRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return null;
    }

    @Override
    public Vet save(Vet object) {
        if(object != null) {
            if(object.getSpecialties() != null) {
                if (object.getSpecialties().size() > 0) {
                    object.getSpecialties().forEach(specialty -> {
                        if (specialty != null) {
                            if (specialty.getId() == null) {
                                specialty.setId(specialtyRepository.save(specialty).getId());
                            }
                        }
                    });
                }
            }
            return vetRepository.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return vetRepository.findByLastName(lastName);
    }
}
