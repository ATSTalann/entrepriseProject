package com.viptic.entrepriseApp.repository;


import com.viptic.entrepriseApp.model.Avance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvanceRepository extends JpaRepository<Avance,Integer> {
}
