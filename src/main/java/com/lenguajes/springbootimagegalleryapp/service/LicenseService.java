package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.License;
import com.lenguajes.springbootimagegalleryapp.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para license
@Service
public class LicenseService {

    // instancia de la clase repositorio
    @Autowired
    private LicenseRepository licenseRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la licencia que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteLicenseById(Long id)
    {
        licenseRepository.deleteById(id);
    }


    // Este método recibe como entrada un Long id que representa el identificador del objeto de la licencia que
    // se desea modificar y un String name que es el nuevo name que se desea asignar.
    public void changeLicenseScientificName(Long id , String name)
    {
        License p = new License();
        p = licenseRepository.findById(id).get();
        p.setType(name);
        licenseRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la licencia que
    // se desea modificar y un boolean attribution que es el nuevo attribution que se desea asignar.
    public void changeAttribution(Long id, boolean attribution) {
        License license = licenseRepository.findById(id).get();
        license.setAttribution(attribution);
        licenseRepository.save(license);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la licencia que
    // se desea modificar y un boolean nonCommercial que es el nuevo nonCommercial que se desea asignar.
    public void changeNonCommercial(Long id, boolean nonCommercial) {
        License license = licenseRepository.findById(id).get();
        license.setNonCommercial(nonCommercial);
        licenseRepository.save(license);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la licencia que
    // se desea modificar y un boolean shareAlike que es el nuevo shareAlike que se desea asignar.
    public void changeShareAlike(Long id, boolean shareAlike) {
        License license = licenseRepository.findById(id).get();
        license.setShareAlike(shareAlike);
        licenseRepository.save(license);
    }

}