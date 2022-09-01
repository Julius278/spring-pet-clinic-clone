package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.model.Pet;
import com.julius.petclinic.model.PetType;
import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.OwnerService;
import com.julius.petclinic.services.PetService;
import com.julius.petclinic.services.PetTypeService;
import com.julius.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;

    private final PetService petService;

    private final OwnerService ownerService;

    private final PetTypeService petTypeService;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService, PetTypeService petTypeService){
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
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
        petTypeService.save(pt1);

        PetType pt2 = new PetType();
        pt2.setName("Dachs");
        petTypeService.save(pt2);

        Owner o1 = new Owner();
        o1.setFirstName("Marge");
        o1.setLastName("Simpson");
        o1.setPets(new HashSet<Pet>());
        o1.setCity("Springfield");
        o1.setAddress("Kwik-E-Mart");
        o1.setTelephone("0013763734...");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Hans");
        o2.setLastName("Wurst");
        o2.setPets(new HashSet<Pet>());
        o2.setCity("Frankfurt");
        o2.setAddress("Europa Allee 6");
        o2.setTelephone("069.....");

        Pet p3 = new Pet();
        PetType pt3 = new PetType();
        pt3.setName("Bird");
        p3.setPetType(pt3);
        p3.setOwner(o2);
        o2.getPets().add(p3);
        ownerService.save(o2);

        Pet p1 = new Pet();
        p1.setPetType(pt1);
        p1.setOwner(o1);
        o1.getPets().add(p1);
        petService.save(p1);

        Pet p2 = new Pet();
        p2.setPetType(pt2);
        p2.setOwner(o1);
        o1.getPets().add(p2);
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
