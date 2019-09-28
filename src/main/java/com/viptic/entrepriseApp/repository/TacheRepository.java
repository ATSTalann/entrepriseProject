package com.viptic.entrepriseApp.repository;

import com.viptic.entrepriseApp.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheRepository extends JpaRepository<Tache,Integer> {

}

