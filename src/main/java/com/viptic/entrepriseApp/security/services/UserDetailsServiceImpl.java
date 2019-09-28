package com.viptic.entrepriseApp.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viptic.entrepriseApp.model.Employer;
import com.viptic.entrepriseApp.repository.EmployerRepository;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
 
  @Autowired(required=true)
  EmployerRepository userRepository;
  
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    Employer user = userRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
 
    return UserPrinciple.build(user);
  }
}
