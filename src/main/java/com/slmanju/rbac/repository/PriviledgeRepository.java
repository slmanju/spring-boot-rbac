package com.slmanju.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slmanju.rbac.domain.Privilege;

public interface PriviledgeRepository extends JpaRepository<Privilege, String> {

}
