package com.souldev.security.security.respositories;

import java.util.Optional;

import com.souldev.security.security.entities.Role;
import com.souldev.security.security.enums.RoleList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
    
}
