package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa un genero taxonomico
@Entity
public class Genus extends Family {

    // Constructores para inicializar una instancia de genero
    public Genus() {}
    public Genus(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }
}
