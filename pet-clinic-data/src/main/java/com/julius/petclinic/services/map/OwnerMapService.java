package com.julius.petclinic.services.map;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.services.CrudService;
import com.julius.petclinic.services.OwnerService;
import com.julius.petclinic.services.PetService;
import com.julius.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet != null) {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                PetType savedPetType = petTypeService.save(pet.getPetType());
                                pet.getPetType().setId(savedPetType.getId());
                            }
                        } else {
                            throw new RuntimeException("PetType is required");
                        }
                        if(pet.getId() == null){
                            pet.setId(petService.save(pet).getId());
                        }
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
