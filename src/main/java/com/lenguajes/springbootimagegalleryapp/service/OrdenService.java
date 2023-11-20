package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Orden;
import com.lenguajes.springbootimagegalleryapp.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para un orden taxonomico
@Service
public class OrdenService {

    // instancia de la clase repositorio
    @Autowired
    private OrdenRepository ordenRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto del orden que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteOrdenById(Long id)
    {
        ordenRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del orden que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeOrdenScientificName(Long id , String name)
    {
        Orden p = new Orden();
        p = ordenRepository.findById(id).get();
        p.setScientificName(name);
        ordenRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del orden que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeOrdenAuthor(Long id , String autor)
    {
        Orden p = new Orden();
        p = ordenRepository.findById(id).get();
        p.setAuthor(autor);
        ordenRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del orden que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeOrdenPublicationYear(Long id, int year)
    {
        Orden p = new Orden();
        p = ordenRepository.findById(id).get();
        p.setPublicationYear(year);
        ordenRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del orden que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeOrdenAncestor(Long id, int ancestor)
    {
        Orden p = new Orden();
        p = ordenRepository.findById(id).get();
        p.setAncestor(ancestor);
        ordenRepository.save(p);
    }

}