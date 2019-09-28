package com.viptic.entrepriseApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viptic.entrepriseApp.model.Role;
import com.viptic.entrepriseApp.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	 Optional<Role> findByName(RoleName roleName);

}
