package com.lenguajes.springbootimagegalleryapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Clase que representa una licencia
@Entity
public class License {
    // Identificador único de la licencia.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Tipo de licencia
    private String type;

    // un booleano que indica si se requiere atribución al autor de la imagen.
    private boolean attribution;

    // un booleano que indica si se permite o no el uso comercial de la imagen.
    private boolean nonCommercial;

    // un booleano que indica si se requiere que las obras derivadas se distribuyan con la misma licencia.
    private boolean shareAlike;

    // Crea una nueva licencia sin inicializar ningún atributo.
    public License() {}

    //Crea una nueva licencia con valores específicos para cada atributo.
    public License(String type, boolean attribution, boolean nonCommercial, boolean shareAlike) {
        this.type = type;
        this.attribution = attribution;
        this.nonCommercial = nonCommercial;
        this.shareAlike = shareAlike;
    }

    //Getters y setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAttribution() {
        return attribution;
    }

    public void setAttribution(boolean attribution) {
        this.attribution = attribution;
    }

    public boolean isNonCommercial() {
        return nonCommercial;
    }

    public void setNonCommercial(boolean nonCommercial) {
        this.nonCommercial = nonCommercial;
    }

    public boolean isShareAlike() {
        return shareAlike;
    }

    public void setShareAlike(boolean shareAlike) {
        this.shareAlike = shareAlike;
    }
}

