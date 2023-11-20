package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;

// Clase que representa un orden taxonomico
@Entity
public class Orden extends Class {

    // Constructores para inicializar una instancia de orden
    public Orden() {}
    public Orden(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        super(id, scientificName, author, publicationYear, ancestor);
    }
}
