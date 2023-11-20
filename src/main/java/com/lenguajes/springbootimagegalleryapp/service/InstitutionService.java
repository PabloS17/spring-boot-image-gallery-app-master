package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Institution;
import com.lenguajes.springbootimagegalleryapp.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para institution
@Service
public class InstitutionService {

    // instancia de la clase repositorio
    @Autowired
    private InstitutionRepository institutionRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteInstitutionById(Long id)
    {
        institutionRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea modificar y un String name que es el nuevo name que se desea asignar.
    public void changeInstitutionName(Long id , String name)
    {
        Institution p = new Institution();
        p = institutionRepository.findById(id).get();
        p.setName(name);
        institutionRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea modificar y un String website que es el nuevo website que se desea asignar.
    public void changeInstitutionWebsite(Long id , String website)
    {
        Institution p = new Institution();
        p = institutionRepository.findById(id).get();
        p.setWebSite(website);
        institutionRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea modificar y un String country que es el nuevo country que se desea asignar.
    public void changeInstitutionCountry(Long id , String country)
    {
        Institution p = new Institution();
        p = institutionRepository.findById(id).get();
        p.setCountry(country);
        institutionRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea modificar y un String phone que es el nuevo phone que se desea asignar.
    public void changeInstitutionPhone(Long id , String phone)
    {
        Institution p = new Institution();
        p = institutionRepository.findById(id).get();
        p.setPhone(phone);
        institutionRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la institucion que
    // se desea modificar y un String email que es el nuevo email que se desea asignar.
    public void changeInstitutionEmail(Long id , String email)
    {
        Institution p = new Institution();
        p = institutionRepository.findById(id).get();
        p.setEmail(email);
        institutionRepository.save(p);
    }

}