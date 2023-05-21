package com.example.hackathon.services;

import com.example.hackathon.entities.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role saveRole(Role role);
    Role updateRole(Long id, Role updatedRole);
    void deleteRole(Long id);
    Role getRoleByRoleName(String roleName);
}
