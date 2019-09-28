package com.viptic.entrepriseApp.repository;

import com.viptic.entrepriseApp.model.Salaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaireRepository extends JpaRepository<Salaire,Integer> {
}
