package com.viptic.entrepriseApp.controller;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.viptic.entrepriseApp.message.request.LoginForm;
import com.viptic.entrepriseApp.message.response.JwtResponse;
import com.viptic.entrepriseApp.model.Employer;
import com.viptic.entrepriseApp.repository.EmployerRepository;
import com.viptic.entrepriseApp.repository.RoleRepository;
import com.viptic.entrepriseApp.security.jwt.JwtProvider;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployerController {
    @Autowired
    EmployerRepository employerRep;
/*
    @Autowired
    RoleRepository roleRepository;
   
    @Autowired(required=true)
    PasswordEncoder encoder;
   
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired(required=true)
    UserDetails userDetails;*/
   
   /* @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
   
      Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
   
      SecurityContextHolder.getContext().setAuthentication(authentication);
   
      String jwt = jwtProvider.generateJwtToken(authentication);
       userDetails = (UserDetails) authentication.getPrincipal();
   
      return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }*/
    @GetMapping("/employers")
    public List<Employer> getAllEmployer() {
        return employerRep.findAll();

    }

    @RequestMapping("employers/employer/{id}")
    public Employer getEmployer(@PathVariable long id){

        return employerRep.findOne(id);    }


    @PostMapping("/employer/add")
    public Employer addEmployer(@Valid @RequestBody Employer emp)
    {
        return employerRep.saveAndFlush(emp);

    }

   /* @PutMapping("/employer/update")
    public Employer updateEmployer(@Valid @RequestBody Employer emp)
    {
        return employerRep.saveAndFlush(emp);

    }*/

    @PutMapping("/employer/update/{idemp}")
    public Employer updateEmployer(@PathVariable long idemp,
                           @Valid @RequestBody Employer employerDetails) {

        Employer employer = employerRep.findOne(idemp);


        employer.setUsername(employerDetails.getUsername());
        employer.setPrenom(employerDetails.getPrenom());
        employer.setEmail(employerDetails.getEmail());
        employer.setPassword(employerDetails.getPassword());
        employer.setDateEmbauche(employerDetails.getDateEmbauche());
        employer.setDateNais(employerDetails.getDateNais());
        employer.setCin(employerDetails.getCin());
        employer.setSituationFamiliale(employerDetails.getSituationFamiliale());
        employer.setAdresse(employerDetails.getAdresse());



        return employerRep.save(employer);
    }



    @DeleteMapping("/employer/delete/{id}")

    public Boolean deleteEmployer(@PathVariable long id)
    {
         employerRep.delete(id);
        return true;
    }

   /* @GetMapping ("monespace/{login}")
    public Employer monespace( @PathVariable String login ,String password) {

        return employerRep.profileDetail(login, password);
    }*/


}




