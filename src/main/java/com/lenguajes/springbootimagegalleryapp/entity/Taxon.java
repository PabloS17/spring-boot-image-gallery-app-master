package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Clase abstracta que representa los atributos de todos los taxones.
@Entity
public abstract class Taxon {
    // Identificador único del taxon.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nombre cientifico del taxon
    private String scientificName;

    // autor del taxon
    private String author;

    // año de publicacion del taxon
    private int publicationYear;

    // ancestro del taxon
    private int ancestor;

    // Crea un nuevo taxon sin inicializar ningún atributo.
    public Taxon() {}

    //Crea un nuevo taxon con valores específicos para cada atributo.
    public Taxon(Long id, String scientificName, String author, int publicationYear, int ancestor) {
        this.id = id;
        this.scientificName = scientificName;
        this.author = author;
        this.publicationYear = publicationYear;
        this.ancestor = ancestor;
    }

    // Getters y setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAncestor(int ancestor) {
        this.ancestor = ancestor;
    }

    public Long getId() {
        return id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getAncestor() {
        return ancestor;
    }

    //public abstract String getRank();
}
