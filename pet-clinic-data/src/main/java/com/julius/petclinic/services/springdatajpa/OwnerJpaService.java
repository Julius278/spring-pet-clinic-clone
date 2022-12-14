package com.julius.petclinic.services.springdatajpa;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.repositories.OwnerRepository;
import com.julius.petclinic.repositories.PetRepository;
import com.julius.petclinic.repositories.PetTypeRepository;
import com.julius.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        //return (Set<Owner>) ownerRepository.findAll();
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        Optional<Owner> optionalOwner = ownerRepository.findById(aLong);
        if(optionalOwner.isEmpty()){
            //throw new RuntimeException("Could not find Owner by Id");
            return null;
        }
        return optionalOwner.get();
    }

    @Override
    public Owner save(Owner object) {
     /*   if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet != null) {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                PetType savedPetType = petTypeRepository.save(pet.getPetType());
                                pet.getPetType().setId(savedPetType.getId());
                            }
                        } else {
                            throw new RuntimeException("PetType is required");
                        }
                        if(pet.getId() == null){
                            pet.setId(petRepository.save(pet).getId());
                        }
                    }
                });
            }
            return ownerRepository.save(object);
        } else {
            return null;
        }*/
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Optional<Owner> optionalOwner = ownerRepository.findByLastName(lastName);

        if(!optionalOwner.isEmpty()){
            return optionalOwner.get();
        }
        return null;
    }
}
