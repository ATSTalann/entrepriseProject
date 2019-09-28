package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Avance;
import com.viptic.entrepriseApp.repository.AvanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AvanceController {
    @Autowired
    AvanceRepository avanceRepository;


    @GetMapping("/avances")
    public List<Avance> getAllAvance() {
        return avanceRepository.findAll();

    }

        @RequestMapping("/avance/{id}")
    public Avance getAvance(@PathVariable Integer id){

        return avanceRepository.findOne(id);

    }


    @PostMapping("/avances/add")
    public Avance addAvance(@Valid @RequestBody Avance avs)
    {
        return avanceRepository.saveAndFlush(avs);

    }


    @PutMapping("/avances/update/{id}")
    public Avance updateAvance(@PathVariable Integer id,
                                 @Valid @RequestBody Avance avanceDetails) {

        Avance avance = avanceRepository.findOne(id);


        avance.setMontant(avanceDetails.getMontant());
            avance.setEmployer(avanceDetails.getEmployer());
            avance.setDecision(avanceDetails.isDecision());
            avance.setDateDemande(avanceDetails.getDateDemande());


        return avanceRepository.save(avance);
    }



    @DeleteMapping("/avances/delete/{id}")

    public Boolean deleteAvance(@PathVariable Integer id)
    {
        avanceRepository.delete(id);
        return true;
    }










}
