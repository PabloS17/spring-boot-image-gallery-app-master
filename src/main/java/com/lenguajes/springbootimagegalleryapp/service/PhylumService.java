package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Phylum;
import com.lenguajes.springbootimagegalleryapp.repository.PhylumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para una division taxonomica
@Service
public class PhylumService {

    // instancia de la clase repositorio
    @Autowired
    private PhylumRepository phylumRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la division que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deletePhylumById(Long id)
    {
        phylumRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la division que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changePhylumScientificName(Long id , String name)
    {
        Phylum p = new Phylum();
        p = phylumRepository.findById(id).get();
        p.setScientificName(name);
        phylumRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la division que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changePhylumAuthor(Long id , String autor)
    {
        Phylum p = new Phylum();
        p = phylumRepository.findById(id).get();
        p.setAuthor(autor);
        phylumRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la division que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changePhylumPublicationYear(Long id, int year)
    {
        Phylum p = new Phylum();
        p = phylumRepository.findById(id).get();
        p.setPublicationYear(year);
        phylumRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la division que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changePhylumAncestor(Long id, int ancestor)
    {
        Phylum p = new Phylum();
        p = phylumRepository.findById(id).get();
        p.setAncestor(ancestor);
        phylumRepository.save(p);
    }

}