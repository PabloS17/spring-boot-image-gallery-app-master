package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa una especie taxonomica
@Entity
public class Species extends Genus {

    // Constructores para inicializar una instancia de especie
    public Species() {}
    public Species(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }

}