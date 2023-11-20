package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para una clase taxonomica
@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}