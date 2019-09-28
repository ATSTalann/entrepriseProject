package com.viptic.entrepriseApp.repository;

import com.viptic.entrepriseApp.model.Absence;
import com.viptic.entrepriseApp.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence,Integer> {

}
