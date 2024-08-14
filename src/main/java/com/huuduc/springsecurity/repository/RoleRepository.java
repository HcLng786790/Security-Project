package com.huuduc.springsecurity.repository;

import com.huuduc.springsecurity.model.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Set<Role> findByName(String name);
}
