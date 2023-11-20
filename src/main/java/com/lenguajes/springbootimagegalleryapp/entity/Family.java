package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa una familia taxonomica
@Entity
public class Family extends Orden {

    // Constructores para inicializar una instancia de familia
    public Family() {}
    public Family(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }
}
