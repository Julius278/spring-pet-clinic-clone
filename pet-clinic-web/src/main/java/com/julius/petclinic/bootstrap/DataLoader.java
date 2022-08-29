package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.Pet;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.OwnerService;
import com.julius.petclinic.services.PetService;
import com.julius.petclinic.services.VetService;
import com.julius.petclinic.services.map.OwnerMapService;
import com.julius.petclinic.services.map.PetMapService;
import com.julius.petclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;

    private final PetService petService;

    private final OwnerService ownerService;

    public DataLoader(VetMapService vetMapService, PetMapService petMapService, OwnerMapService ownerMapService){
        this.vetService = vetMapService;
        this.petService = petMapService;
        this.ownerService = ownerMapService;
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
        pt1.setId(new Long(345));

        PetType pt2 = new PetType();
        pt2.setName("Dachs");
        pt2.setId(new Long(346));


        Owner o1 = new Owner();
        o1.setFirstName("Marge");
        o1.setLastName("Simpson");
        o1.setId(new Long(123));
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Hans");
        o2.setLastName("Wurst");
        o2.setId(new Long(124));
        ownerService.save(o2);

        Pet p1 = new Pet();
        p1.setPetType(pt1);
        p1.setOwner(o1);
        p1.setId(new Long(124));
        petService.save(p1);

        Pet p2 = new Pet();
        p2.setPetType(pt2);
        p2.setOwner(o1);
        p2.setId(new Long(125));
        petService.save(p2);

    }

    private void bootstrapVets(){
        Vet v1 = new Vet();
        v1.setFirstName("Peter");
        v1.setLastName("Griffin");
        v1.setId(new Long(111));
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Homer");
        v2.setLastName("Simpson");
        v2.setId(new Long(222));
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
