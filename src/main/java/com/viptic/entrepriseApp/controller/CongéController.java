package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Congé;
import com.viptic.entrepriseApp.repository.CongéRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CongéController {
    @Autowired
    CongéRepository congéRepository;

    @GetMapping("/congés")
    public List<Congé> getAllCongé() {
        return congéRepository.findAll();

    }

    @RequestMapping("congés/congé/{id}")
    public Congé getCongé(@PathVariable Integer id){

        return congéRepository.findOne(id);

    }


    @PostMapping("/congés/add")
    public Congé addCongé(@Valid @RequestBody Congé congé)
    {
        return congéRepository.saveAndFlush(congé);

    }


    @PutMapping("/congés/update/{id}")
    public Congé updateCongé(@PathVariable Integer id,
                                     @Valid @RequestBody Congé congéDetails) {

        Congé congé= congéRepository.findOne(id);
congé.setDateDeb(congéDetails.getDateDeb());
congé.setDateFin(congéDetails.getDateFin());
congé.setEmployer(congéDetails.getEmployer());
congé.setRaison(congéDetails.getRaison());



        return congéRepository.save(congé);
    }



    @DeleteMapping("/congés/delete/{id}")

    public Boolean deleteCongé(@PathVariable Integer id)
    {
        congéRepository.delete(id);
        return true;
    }
}
