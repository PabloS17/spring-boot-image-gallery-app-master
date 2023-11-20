package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Image;
import com.lenguajes.springbootimagegalleryapp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// Clase service para image
@Service
public class ImageService {

    // instancia de la clase repositorio
    @Autowired
    private ImageRepository imageRepository;

    // Este método recibe como entrada un Image image que representa el identificador del objeto de la imagen que
    // se desea guardar. El método llama al método save() del repositorio y le pasa el identificador.
    public void saveImage(Image image) {
        imageRepository.save(image);
    }

    // Este método no recibe nada como entrada.
    // El método llama al método findAll() del repositorio.
    public List<Image> getAllActiveImages() {
        return imageRepository.findAll();
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea obtener. El método llama al método findById() del repositorio y le pasa el identificador.
    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deleteProductById(Long id)
    {
        imageRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un String description que es el nuevo description que se desea asignar.
    public void changeImageDescription(Long id , String description)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setDescription(description);
        imageRepository.save(p);
    }


    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un Date date que es el nuevo date que se desea asignar.
    public void changeImageDate(Long id, Date date) {
        Image p = imageRepository.findById(id).orElse(null);
        if (p != null) {
            p.setDate(date);
            imageRepository.save(p);
        }
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un String keywords que es el nuevo keywords que se desea asignar.
    public void changeImageKeywords(Long id , String keywords)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setKeywords(keywords);
        imageRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un int autor que es el nuevo autor que se desea asignar.
    public void changeImageAuthor(Long id, int autor)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setAuthor(autor);
        imageRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un int owner que es el nuevo owner que se desea asignar.
    public void changeImageOwner(Long id, int owner)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setOwner(owner);
        imageRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un int license que es el nuevo license que se desea asignar.
    public void changeImageLicense(Long id, int license)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setLicense(license);
        imageRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la imagen que
    // se desea modificar y un int taxons que es el nuevo taxons que se desea asignar.
    public void changeImageTaxons(Long id, int taxons)
    {
        Image p = new Image();
        p = imageRepository.findById(id).get();
        p.setTaxons(taxons);
        imageRepository.save(p);
    }

}