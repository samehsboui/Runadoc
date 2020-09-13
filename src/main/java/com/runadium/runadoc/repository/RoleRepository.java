package com.runadium.runadoc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.runadium.runadoc.enumeration.RoleName;
import com.runadium.runadoc.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Optional<Role> findByName(RoleName roleName);
}