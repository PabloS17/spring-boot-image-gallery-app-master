package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Class;
import com.lenguajes.springbootimagegalleryapp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para una clase taxonomica
@Service
public class ClassService {

    // instancia de la clase repositorio
    @Autowired
    private ClassRepository classRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la clase que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteClassById(Long id)
    {
        classRepository.deleteById(id);
    }


    // Este método recibe como entrada un Long id que representa el identificador del objeto de la clase que
    // se desea modificar y un String name que es el nuevo nombre científico que se desea asignar. El método
    // primero obtiene el objeto a través del método findById() del repositorio, lo modifica y finalmente lo guarda
    // de nuevo en la base de datos.
    public void changeClassScientificName(Long id , String name)
    {
        Class p = new Class();
        p = classRepository.findById(id).get();
        p.setScientificName(name);
        classRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la clase que
    // se desea modificar y un String autor que es el nuevo autor que se desea asignar.
    public void changeClassAuthor(Long id , String autor)
    {
        Class p = new Class();
        p = classRepository.findById(id).get();
        p.setAuthor(autor);
        classRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la clase que
    // se desea modificar y un int year que es el nuevo año de publicación que se desea asignar.
    public void changeClassPublicationYear(Long id, int year)
    {
        Class p = new Class();
        p = classRepository.findById(id).get();
        p.setPublicationYear(year);
        classRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la clase que
    // se desea modificar y un int ancestor que es el nuevo ancestro que se desea asignar.
    public void changeClassAncestor(Long id, int ancestor)
    {
        Class p = new Class();
        p = classRepository.findById(id).get();
        p.setAncestor(ancestor);
        classRepository.save(p);
    }

}