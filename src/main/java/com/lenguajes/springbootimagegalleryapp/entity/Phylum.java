package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa una division taxonomica
@Entity
public class Phylum extends Kingdom {

    // Constructores para inicializar una instancia de division
    public Phylum() {}
    public Phylum(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }
}
