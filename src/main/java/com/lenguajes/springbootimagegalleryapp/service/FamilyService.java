package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Family;
import com.lenguajes.springbootimagegalleryapp.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para una familia taxonomica
@Service
public class FamilyService {

    // instancia de la clase repositorio
    @Autowired
    private FamilyRepository familyRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la familia que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteFamilyById(Long id)
    {
        familyRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la familia que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeFamilyScientificName(Long id , String name)
    {
        Family p = new Family();
        p = familyRepository.findById(id).get();
        p.setScientificName(name);
        familyRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la familia que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeFamilyAuthor(Long id , String autor)
    {
        Family p = new Family();
        p = familyRepository.findById(id).get();
        p.setAuthor(autor);
        familyRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la familia que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeFamilyPublicationYear(Long id, int year)
    {
        Family p = new Family();
        p = familyRepository.findById(id).get();
        p.setPublicationYear(year);
        familyRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la familia que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeFamilyAncestor(Long id, int ancestor)
    {
        Family p = new Family();
        p = familyRepository.findById(id).get();
        p.setAncestor(ancestor);
        familyRepository.save(p);
    }

}