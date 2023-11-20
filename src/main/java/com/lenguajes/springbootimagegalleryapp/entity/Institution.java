package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Clase que representa una institucion
@Entity
public class Institution {
    // Identificador único de la institucion.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nombre de la institucion
    private String name;

    // Pais de la institucion
    private String country;

    // Telefono de la institucion
    private String phone;

    // Correo de la institucion
    private String email;

    // Pagina web de la institucion
    private String webSite;

    // Crea una nueva institucion sin inicializar ningún atributo.
    public Institution() {}

    //Crea una nueva institucion con valores específicos para cada atributo.
    public Institution(int id, String name, String country, String phone, String email, String webSite) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.webSite = webSite;
    }

    //Getters y setters

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
