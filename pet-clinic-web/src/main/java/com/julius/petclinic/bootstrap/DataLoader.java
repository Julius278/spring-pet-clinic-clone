package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.*;
import com.julius.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetService vetService;

    private final PetService petService;

    private final OwnerService ownerService;

    private final PetTypeService petTypeService;

    private final SpecialtyService specialtyService;

    private final VisitService visitService;

    public DataLoader(VetService vetService, PetService petService, OwnerService ownerService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.vetService = vetService;
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() == 0) {
            bootstrapVets();
            bootstrapPets();
        }
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
        o1.setCity("Springfield");
        o1.setAddress("Kwik-E-Mart");
        o1.setTelephone("0013763734...");
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Hans");
        o2.setLastName("Wurst");
        o2.setCity("Frankfurt");
        o2.setAddress("Europa Allee 6");
        o2.setTelephone("069.....");

        Pet p3 = new Pet();
        PetType pt3 = new PetType();
        pt3.setName("Bird");
        p3.setPetType(pt3);
        p3.setOwner(o2);
        p3.setName("Rex");
        o2.getPets().add(p3);
        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Mike");
        o3.setLastName("Krüger");
        o3.setCity("Ulm");
        o3.setAddress("Hauptstraße");
        o3.setTelephone("0049 7304...");
        ownerService.save(o3);

        Pet p1 = new Pet();
        p1.setPetType(pt1);
        p1.setOwner(o1);
        p1.setName("Strolch");
        o1.getPets().add(p1);

        Visit v1 = new Visit(LocalDate.now(), "test description 123");
        visitService.save(v1);
        p1.addVisit(v1);

        petService.save(p1);

        Pet p2 = new Pet();
        p2.setPetType(pt2);
        p2.setOwner(o1);
        p2.setName("Honig");
        o1.getPets().add(p2);

        Visit v2 = new Visit(LocalDate.now(), "first test description 234", p2);
        visitService.save(v2);
        p2.addVisit(v2);

        Visit v3 = new Visit(LocalDate.now(), "second test description 345", p2);
        visitService.save(v3);
        p2.addVisit(v3);

        petService.save(p2);

    }

    private void bootstrapVets(){

        Specialty s1 = new Specialty();
        s1.setDescription("radiology");
        specialtyService.save(s1);

        Specialty s2 = new Specialty();
        s2.setDescription("surgery");
        s2.setId(specialtyService.save(s2).getId());

        Specialty s3 = new Specialty();
        s3.setDescription("dentistry");
        s3.setId(specialtyService.save(s3).getId());

        Vet v1 = new Vet();
        v1.setFirstName("Peter");
        v1.setLastName("Griffin");
        v1.getSpecialties().add(s2);
        //v1.getSpecialties().add(s1);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Homer");
        v2.setLastName("Simpson");
        v2.getSpecialties().add(s2);
        v2.getSpecialties().add(s3);
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

        for (Specialty s:specialtyService.findAll()) {
            System.out.println(s.toString());
        }

        for( Visit v: visitService.findAll()){
            System.out.println(v.toString());
        }
    }
}
