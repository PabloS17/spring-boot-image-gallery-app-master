package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Kingdom;
import com.lenguajes.springbootimagegalleryapp.repository.KingdomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para un reino taxonomico
@Service
public class KingdomService {

    // instancia de la clase repositorio
    @Autowired
    private KingdomRepository kingdomRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto del reino que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteKingdomById(Long id)
    {
        kingdomRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del reino que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeKingdomScientificName(Long id ,String name)
    {
        Kingdom p = new Kingdom();
        p = kingdomRepository.findById(id).get();
        p.setScientificName(name);
        kingdomRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del reino que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeKingdomAuthor(Long id , String autor)
    {
        Kingdom p = new Kingdom();
        p = kingdomRepository.findById(id).get();
        p.setAuthor(autor);
        kingdomRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del reino que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeKingdomPublicationYear(Long id, int year)
    {
        Kingdom p = new Kingdom();
        p = kingdomRepository.findById(id).get();
        p.setPublicationYear(year);
        kingdomRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto del reino que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeKingdomAncestor(Long id, int ancestor)
    {
        Kingdom p = new Kingdom();
        p = kingdomRepository.findById(id).get();
        p.setAncestor(ancestor);
        kingdomRepository.save(p);
    }

}