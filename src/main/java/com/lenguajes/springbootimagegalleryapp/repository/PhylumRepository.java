package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Phylum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para una division taxonomica
@Repository
public interface PhylumRepository extends JpaRepository<Phylum, Long> {

}