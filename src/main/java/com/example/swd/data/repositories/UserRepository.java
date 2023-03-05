package com.example.swd.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swd.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
