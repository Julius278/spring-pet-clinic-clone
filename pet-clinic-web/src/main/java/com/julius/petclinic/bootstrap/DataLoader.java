package com.julius.petclinic.bootstrap;

import com.julius.petclinic.model.Vet;
import com.julius.petclinic.services.VetService;
import com.julius.petclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final VetMapService vetMapService;

    public DataLoader(VetMapService vetMapService){
        this.vetMapService = vetMapService;
    }

    @Override
    public void run(String... args) throws Exception {
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

        for (Vet ve:
                vetMapService.findAll()) {
            System.out.println(ve.getId()+" "+ve.getFirstName() + " " + ve.getLastName());
        }
    }
}
