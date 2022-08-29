package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.Pet;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.OwnerService;
import com.julius.petclinic.services.PetService;
import com.julius.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;

    private final PetService petService;

    private final OwnerService ownerService;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService){
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        bootstrapVets();
        bootstrapPets();

        printAllData();
    }

    private void bootstrapPets(){
        PetType pt1 = new PetType();
        pt1.setName("Streuner");

        PetType pt2 = new PetType();
        pt2.setName("Dachs");


        Owner o1 = new Owner();
        o1.setFirstName("Marge");
        o1.setLastName("Simpson");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Hans");
        o2.setLastName("Wurst");
        ownerService.save(o2);

        Pet p1 = new Pet();
        p1.setPetType(pt1);
        p1.setOwner(o1);
        petService.save(p1);

        Pet p2 = new Pet();
        p2.setPetType(pt2);
        p2.setOwner(o1);
        petService.save(p2);

    }

    private void bootstrapVets(){
        Vet v1 = new Vet();
        v1.setFirstName("Peter");
        v1.setLastName("Griffin");
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Homer");
        v2.setLastName("Simpson");
        vetService.save(v2);
    }

    private void printAllData(){
        for (Vet ve:vetService.findAll()) {
            System.out.println(ve.toString());
        }

        for (Pet p:petService.findAll()) {
            System.out.println(p.toString());
        }

        for (Owner o:ownerService.findAll()) {
            System.out.println(o.toString());
        }
    }
}
