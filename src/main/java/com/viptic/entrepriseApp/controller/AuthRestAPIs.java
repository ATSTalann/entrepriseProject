package com.viptic.entrepriseApp.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viptic.entrepriseApp.message.request.LoginForm;
import com.viptic.entrepriseApp.message.request.SignUpForm;
import com.viptic.entrepriseApp.message.response.JwtResponse;
import com.viptic.entrepriseApp.message.response.ResponseMessage;
import com.viptic.entrepriseApp.model.Employer;
import com.viptic.entrepriseApp.model.Role;
import com.viptic.entrepriseApp.model.RoleName;
import com.viptic.entrepriseApp.repository.EmployerRepository;
import com.viptic.entrepriseApp.repository.RoleRepository;
import com.viptic.entrepriseApp.security.jwt.JwtProvider;
 


@RestController

public class AuthRestAPIs {
	
  @Autowired(required=true)
  AuthenticationManager authenticationManager;
 
  @Autowired
  EmployerRepository  userRepository;
 
  @Autowired(required=true)
  RoleRepository roleRepository;
 
  @Autowired(required=true)
  PasswordEncoder encoder;
 
  @Autowired(required=true)
  JwtProvider jwtProvider;
 
  @PostMapping("/api/auth/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
   Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
  }
  @PostMapping("/api/auth/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
          HttpStatus.BAD_REQUEST);
    }
 
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
          HttpStatus.BAD_REQUEST);
    }
 
    // Creating user's account
    Employer user = new  Employer( signUpRequest.getDateEmbauche(), signUpRequest.getDateNais(), signUpRequest.getUsername(), signUpRequest.getPrenom(), signUpRequest.getSituationFamiliale(),
    		signUpRequest.getAdresse(),signUpRequest.getCin(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getPhoto()) ;
		
   // Employer user = new Employer(signUpRequest.getPrenom(), signUpRequest.getUsername(), signUpRequest.getEmail(),
        //encoder.encode(signUpRequest.getPassword()));
 
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
 
    strRoles.forEach(role -> {
      switch (role) {
      case "admin":
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(adminRole);
 
        break;
      case "pm":
        Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(pmRole);
 
        break;
      default:
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
      }
    });
 
    user.setRoles(roles);
    userRepository.save(user);
 
    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
  }
}
 
  
