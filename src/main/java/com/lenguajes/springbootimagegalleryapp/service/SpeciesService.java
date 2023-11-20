package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Species;
import com.lenguajes.springbootimagegalleryapp.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para una especie taxonomica
@Service
public class SpeciesService {

    // instancia de la clase repositorio
    @Autowired
    private SpeciesRepository speciesRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la especie que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteSpeciesById(Long id)
    {
        speciesRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la especie que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeSpeciesScientificName(Long id , String name)
    {
        Species p = new Species();
        p = speciesRepository.findById(id).get();
        p.setScientificName(name);
        speciesRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la especie que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeSpeciesAuthor(Long id , String autor)
    {
        Species p = new Species();
        p = speciesRepository.findById(id).get();
        p.setAuthor(autor);
        speciesRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la especie que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeSpeciesPublicationYear(Long id, int year)
    {
        Species p = new Species();
        p = speciesRepository.findById(id).get();
        p.setPublicationYear(year);
        speciesRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la especie que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeSpeciesAncestor(Long id, int ancestor)
    {
        Species p = new Species();
        p = speciesRepository.findById(id).get();
        p.setAncestor(ancestor);
        speciesRepository.save(p);
    }

}