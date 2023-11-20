package com.lenguajes.springbootimagegalleryapp.repository;

import com.lenguajes.springbootimagegalleryapp.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio para una licencia
@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {

}