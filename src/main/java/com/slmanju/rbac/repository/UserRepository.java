package com.slmanju.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slmanju.rbac.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
