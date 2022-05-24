package com.souldev.security.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.souldev.security.security.entities.Role;
import com.souldev.security.security.enums.RoleList;
import com.souldev.security.security.respositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }
    
    
}
