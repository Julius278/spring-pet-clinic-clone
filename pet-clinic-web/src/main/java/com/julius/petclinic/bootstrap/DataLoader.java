package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.Pet;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.map.OwnerMapService;
import com.julius.petclinic.services.map.PetMapService;
import com.julius.petclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetMapService vetMapService;

    private final PetMapService petMapService;

    private final OwnerMapService ownerMapService;

    public DataLoader(VetMapService vetMapService, PetMapService petMapService, OwnerMapService ownerMapService){
        this.vetMapService = vetMapService;
        this.petMapService = petMapService;
        this.ownerMapService = ownerMapService;
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
        ownerMapService.save(o1);

        Pet p1 = new Pet();
        p1.setPetType(pt1);
        p1.setOwner(o1);
        p1.setId(new Long(124));
        petMapService.save(p1);

        Pet p2 = new Pet();
        p2.setPetType(pt2);
        p2.setOwner(o1);
        p2.setId(new Long(125));
        petMapService.save(p2);

    }

    private void bootstrapVets(){
        Vet v1 = new Vet();
        v1.setFirstName("Peter");
        v1.setLastName("Griffin");
        v1.setId(new Long(111));
        vetMapService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Homer");
        v2.setLastName("Simpson");
        v2.setId(new Long(222));
        vetMapService.save(v2);
    }

    private void printAllData(){
        for (Vet ve:vetMapService.findAll()) {
            System.out.println(ve.toString());
        }

        for (Pet p:petMapService.findAll()) {
            System.out.println(p.toString());
        }

        for (Owner o:ownerMapService.findAll()) {
            System.out.println(o.toString());
        }
    }
}
