package com.viptic.entrepriseApp.repository;

import com.viptic.entrepriseApp.model.Congé;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongéRepository extends JpaRepository<Congé,Integer> {
}
