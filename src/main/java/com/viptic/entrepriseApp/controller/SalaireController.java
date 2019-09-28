package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Salaire;
import com.viptic.entrepriseApp.repository.SalaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class SalaireController {


    @Autowired
    SalaireRepository salaireRepository;


    @GetMapping("/salaires")
    public List<Salaire> getAllSalaire() {
        return salaireRepository.findAll();

    }

    @RequestMapping("/salaires/{id}")
    public Salaire getSalaire(@PathVariable Integer id){

        return salaireRepository.findOne(id);

    }


    @PostMapping("/salaires/add")
    public Salaire addSalaire(@Valid @RequestBody Salaire s)
    {
        return salaireRepository.saveAndFlush(s);

    }


    @PutMapping("/salaire/update/{id}")
    public Salaire updateAvance(@PathVariable Integer id,
                               @Valid @RequestBody Salaire salaireDetails) {
Salaire salaire=salaireRepository.findOne(id);

salaire.setDateDeb(salaireDetails.getDateDeb());
salaire.setDateFin(salaireDetails.getDateFin());
salaire.setEmployer(salaireDetails.getEmployer());
salaire.setSalaireNet(salaireDetails.getSalaireNet());
salaire.setTotalPrime(salaireDetails.getTotalPrime());
salaire.setTotalRetenu(salaireDetails.getTotalRetenu());


        return salaireRepository.save(salaire);
    }



    @DeleteMapping("/salaires/delete/{id}")

    public Boolean deleteSalaire(@PathVariable Integer id)
    {
        salaireRepository.delete(id);
        return true;
    }

}
