package com.slmanju.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slmanju.rbac.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
