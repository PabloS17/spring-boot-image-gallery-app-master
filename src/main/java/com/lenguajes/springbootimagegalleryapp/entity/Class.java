package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa una clase taxonomica
@Entity
public class Class extends Phylum {

    // Constructores para inicializar una instancia de clase
    public Class() {}
    public Class(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }
}
