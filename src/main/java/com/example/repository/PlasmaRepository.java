package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Plasma;

@Repository
public interface PlasmaRepository extends JpaRepository<Plasma, Integer> {
 
}