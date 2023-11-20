package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Clase que representa una imagen
@Entity
public class Image {
    // Identificador único de la imagen.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Descripción de la imagen.
    private String description;

    // Fecha de creación de la imagen.
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // Palabras clave asociadas con la imagen.
    private String keywords;

    //Identificador del autor de la imagen.
    private int author;

    // Identificador del propietario de la imagen.
    private int owner;

    // Identificador de la licencia de la imagen.
    private int license;

    // Identificador de la categoría taxonómica de la imagen.
    private int taxons;

    // Representación binaria de la imagen.
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] imagen;

    // Atributo estatico para llevar una cuenta de la cantidad de imagenes
    private static int count = 0;

    // Crea una nueva imagen sin inicializar ningún atributo.
    public Image() {}

    //Crea una nueva imagen con valores específicos para cada atributo.
    public Image(String description, Date date, String keywords, int author, int owner,
                 int license, int taxons) {
        this.description = description;
        this.date = date;
        this.keywords = keywords;
        this.author = author;
        this.owner = owner;
        this.license = license;
        this.taxons = taxons;
        count+= 1;
    }

    // metodo estatico para obtener la cuenta de la cantidad de imagenes.
    public static int getCount() {
        return count;
    }

    //Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public int getTaxons() {
        return taxons;
    }

    public void setTaxons(int taxons) {
        this.taxons = taxons;
    }

    public byte[] getImage() {
        return imagen;
    }

    public void setImage(byte[] image) {
        this.imagen = image;
    }
}
