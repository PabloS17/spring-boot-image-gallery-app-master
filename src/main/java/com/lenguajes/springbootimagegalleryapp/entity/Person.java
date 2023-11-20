package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Clase que representa una persona
@Entity
public class Person {
    // Identificador único de la persona.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nombre de la persona
    private String name;

    // Apellido de la persona
    private String lastName;

    // Pais de la persona
    private String country;

    // Telefono de la persona
    private String phone;

    // Correo de la persona
    private String email;

    // Crea una nueva persona sin inicializar ningún atributo.
    public Person() {}

    //Crea una nueva persona con valores específicos para cada atributo.
    public Person(int id, String name, String lastName, String country, String phone, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    //Getters y setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
