package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para una institucion
@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}