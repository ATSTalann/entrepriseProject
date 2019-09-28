package com.viptic.entrepriseApp.repository;

import com.viptic.entrepriseApp.model.Employer;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {

   /* @Query("select e from Employer e where e.login=:login and e.password=:password")
    public Employer profileDetail(String login, String password);*/
	/*@Query("select e from Employer e where e.id=:id")
	Employer findById(@Param("id") long id);
	
    Optional<Employer> findByUsername(String username);
    @Query("delete from Employer e where e.id=:id")
    Employer deleteById(@Param("id")long id);*/
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
