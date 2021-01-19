package com.example.demo.services;

import com.example.demo.entities.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DemoUser, Integer> {}
