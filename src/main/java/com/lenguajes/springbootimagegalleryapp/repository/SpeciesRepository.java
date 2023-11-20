package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para una especie taxonomica
@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

}