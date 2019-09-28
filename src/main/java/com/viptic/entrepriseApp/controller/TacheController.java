package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Tache;
import com.viptic.entrepriseApp.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class TacheController {

    @Autowired
    TacheRepository tacheRepository;


    @GetMapping("/taches")
    public List<Tache> getAllTache() {
        return tacheRepository.findAll();

    }

    @RequestMapping("/tache/{id}")
    public Tache getTache(@PathVariable Integer id){

        return tacheRepository.findOne(id);

    }


    @PostMapping("/taches/add")
    public Tache addTache(@Valid @RequestBody Tache t)
    {
        return tacheRepository.saveAndFlush(t);

    }


    @PutMapping("/taches/update/{id}")
    public Tache updateTache(@PathVariable Integer id,
                               @Valid @RequestBody Tache tacheDetails) {

        Tache tache = tacheRepository.findOne(id);


        tache.setDateDeb(tacheDetails.getDateDeb());
        tache.setDateFin(tacheDetails.getDateFin());
        tache.setEmployer(tacheDetails.getEmployer());
        tache.setNom(tacheDetails.getNom());
        tache.setProjets(tacheDetails.getProjets());


        return tacheRepository.save(tache);
    }



    @DeleteMapping("/taches/delete/{id}")

    public Boolean deleteTache(@PathVariable Integer id)
    {
        tacheRepository.delete(id);
        return true;
    }

}
