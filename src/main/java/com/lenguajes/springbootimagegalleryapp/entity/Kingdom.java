package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa una reino taxonomico
@Entity
public class Kingdom extends Taxon {

    // Constructores para inicializar una instancia de reino
    public Kingdom() {}
    public Kingdom(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }

}
