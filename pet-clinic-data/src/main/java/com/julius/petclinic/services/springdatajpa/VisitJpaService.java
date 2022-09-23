package com.julius.petclinic.services.springdatajpa;

import com.julius.petclinic.model.Visit;
import com.julius.petclinic.repositories.VisitRepository;
import com.julius.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class VisitJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        Optional<Visit> visitOptional = visitRepository.findById(aLong);
        if(visitOptional.isPresent()){
            return visitOptional.get();
        }
        return null;
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
