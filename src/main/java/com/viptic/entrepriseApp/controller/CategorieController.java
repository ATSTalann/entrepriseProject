package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Categorie;
import com.viptic.entrepriseApp.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CategorieController {

@Autowired
    CategorieRepository categorieRepository;

    @GetMapping("/categories")
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();

    }

    @RequestMapping("categories/categorie/{id}")
    public Categorie getCategorie(@PathVariable Integer id){

        return categorieRepository.findOne(id);

    }


    @PostMapping("/categories/add")
    public Categorie addCategories(@Valid @RequestBody Categorie categorie)
    {
        return categorieRepository.saveAndFlush(categorie);

    }


    @PutMapping("/categories/update/{id}")
    public Categorie updateCategorie(@PathVariable Integer id,
                               @Valid @RequestBody Categorie categorieDetails) {

        Categorie  categorie= categorieRepository.findOne(id);


        categorie.setDescription(categorieDetails.getDescription());
        categorie.setEmployer(categorieDetails.getEmployer());
       categorie.setPrixHeure(categorieDetails.getPrixHeure());
       categorie.setSalaireBase(categorieDetails.getSalaireBase());

        return categorieRepository.save(categorie);
    }



    @DeleteMapping("/categories/delete/{id}")

    public Boolean deleteCategorie(@PathVariable Integer id)
    {
        categorieRepository.delete(id);
        return true;
    }
}
