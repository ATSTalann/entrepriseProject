package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Projet;
import com.viptic.entrepriseApp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;


    @GetMapping("/projets")
    public List<Projet> getAllProjet() {
        return projectRepository.findAll();


    }

    @RequestMapping("projets/projet/{id}")
    public Projet getProjet(@PathVariable Integer id){

        return projectRepository.findOne(id);

    }


    @PostMapping("/projet/add")
    public Projet addProjet(@Valid @RequestBody Projet p)
    {
        return projectRepository.saveAndFlush(p);

    }

   /* @PutMapping("/employer/update")
    public Employer updateEmployer(@Valid @RequestBody Employer emp)
    {
        return employerRep.saveAndFlush(emp);

    }*/

    @PutMapping("/projets/update/{id}")
    public Projet updateProjet(@PathVariable Integer id,
                                   @Valid @RequestBody Projet projetDetails) {

        Projet projet = projectRepository.findOne(id);
projet.setDateDeb(projetDetails.getDateDeb());
projet.setDateDebEstimer(projetDetails.getDateDebEstimer());
projet.setDateFin(projetDetails.getDateFin());
projet.setDateFinEstimer(projetDetails.getDateFinEstimer());
projet.setNom(projetDetails.getNom());





        return projectRepository.save(projet);
    }



    @DeleteMapping("/projets/delete/{id}")

    public Boolean deleteProjet(@PathVariable Integer id)
    {
        projectRepository.delete(id);
        return true;
    }

}
