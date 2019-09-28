package com.viptic.entrepriseApp.controller;

import com.viptic.entrepriseApp.model.Absence;
import com.viptic.entrepriseApp.model.Employer;
import com.viptic.entrepriseApp.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AbsenceController {
    @Autowired
    AbsenceRepository absenceRepository;


    @GetMapping("/absences")
    public List<Absence> getAllAbsence() {
        return absenceRepository.findAll();


    }

    @RequestMapping("absences/absence/{id}")
    public Absence getAbsence(@PathVariable Integer id){

        return absenceRepository.findOne(id);

    }


    @PostMapping("/absences/add")
    public Absence addAbsence(@Valid @RequestBody Absence abs)
    {
        return absenceRepository.saveAndFlush(abs);

    }


    @PutMapping("/absence/update/{id}")
    public Absence updateAbsence(@PathVariable Integer id,
                                   @Valid @RequestBody Absence absenceDetails) {

        Absence absence = absenceRepository.findOne(id);


        absence.setNbrHeure(absenceDetails.getNbrHeure());
        absence.setNbrJour(absenceDetails.getNbrJour());
        absence.setDateAbs(absenceDetails.getDateAbs());
        absence.setEmployer(absenceDetails.getEmployer());

        return absenceRepository.save(absence);
    }



    @DeleteMapping("/absence/delete/{id}")

    public Boolean deleteAbsence(@PathVariable Integer id)
    {
        absenceRepository.delete(id);
        return true;
    }
}
