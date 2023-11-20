package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para un reino taxonomico
@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, Long> {

}