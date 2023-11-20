package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Genus;
import com.lenguajes.springbootimagegalleryapp.repository.GenusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para un genero taxonomico
@Service
public class GenusService {

    // instancia de la clase repositorio
    @Autowired
    private GenusRepository genusRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto del genero que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteGenusById(Long id)
    {
        genusRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del genero que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeGenusScientificName(Long id , String name)
    {
        Genus p = new Genus();
        p = genusRepository.findById(id).get();
        p.setScientificName(name);
        genusRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del genero que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeGenusAuthor(Long id , String autor)
    {
        Genus p = new Genus();
        p = genusRepository.findById(id).get();
        p.setAuthor(autor);
        genusRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del genero que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeGenusPublicationYear(Long id,int year)
    {
        Genus p = new Genus();
        p = genusRepository.findById(id).get();
        p.setPublicationYear(year);
        genusRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del genero que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeGenusAncestor(Long id, int ancestor)
    {
        Genus p = new Genus();
        p = genusRepository.findById(id).get();
        p.setAncestor(ancestor);
        genusRepository.save(p);
    }

}