package com.julius.petclinic.services.map;

import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.SpecialtyService;
import com.julius.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        if(object != null) {
            if(object.getSpecialties() != null) {
                if (object.getSpecialties().size() > 0) {
                    object.getSpecialties().forEach(specialty -> {
                        if (specialty != null) {
                            if (specialty.getId() == null) {
                                specialty.setId(specialtyService.save(specialty).getId());
                            }
                        }
                    });
                }
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        return null;
    }
}
