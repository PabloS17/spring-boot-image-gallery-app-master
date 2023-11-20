package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Genus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para un genero taxonomico
@Repository
public interface GenusRepository extends JpaRepository<Genus, Long> {

}