package com.lenguajes.springbootimagegalleryapp.service;

import com.lenguajes.springbootimagegalleryapp.entity.Person;
import com.lenguajes.springbootimagegalleryapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Clase service para person
@Service
public class PersonService {

    // instancia de la clase repositorio
    @Autowired
    private PersonRepository personRepository;

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea eliminar. El método llama al método deleteById() del repositorio y le pasa el identificador.
    public void deletePersonById(Long id)
    {
        personRepository.deleteById(id);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea modificar y un String name que es el nuevo name que se desea asignar.
    public void changePersonName(Long id , String name)
    {
        Person p = new Person();
        p = personRepository.findById(id).get();
        p.setName(name);
        personRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea modificar y un String lastname que es el nuevo lastname que se desea asignar.
    public void changePersonLastName(Long id , String lastname)
    {
        Person p = new Person();
        p = personRepository.findById(id).get();
        p.setLastName(lastname);
        personRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea modificar y un String country que es el nuevo country que se desea asignar.
    public void changePersonCountry(Long id , String country)
    {
        Person p = new Person();
        p = personRepository.findById(id).get();
        p.setCountry(country);
        personRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea modificar y un String phone que es el nuevo phone que se desea asignar.
    public void changePersonPhone(Long id , String phone)
    {
        Person p = new Person();
        p = personRepository.findById(id).get();
        p.setPhone(phone);
        personRepository.save(p);
    }

    // Este método recibe como entrada un Long id que representa el identificador del objeto de la persona que
    // se desea modificar y un String email que es el nuevo email que se desea asignar.
    public void changePersonEmail(Long id , String email)
    {
        Person p = new Person();
        p = personRepository.findById(id).get();
        p.setEmail(email);
        personRepository.save(p);
    }

}