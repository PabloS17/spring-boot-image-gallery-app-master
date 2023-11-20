package com.lenguajes.springbootimagegalleryapp.controller;

import com.lenguajes.springbootimagegalleryapp.entity.Image;
import com.lenguajes.springbootimagegalleryapp.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Clase controller para image
@Controller
public class ImageController {

    // una cadena de caracteres que representa la ruta donde se guardarán las imágenes subidas por el usuario.
    @Value("${uploadDir}")
    private String uploadFolder;

    // instancia de la clase service
    @Autowired
    private ImageService imageService;

    // una instancia de la clase "Logger" que se utiliza para registrar los mensajes de registro.
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // método que devuelve una cadena de caracteres que representa la página de inicio del sitio web.
    @GetMapping(value = {"/", "/home"})
    public String addImagePage() {
        return "index";
    }

    // Método que recibe la información de la imagen, la imagen en sí misma y la guarda en el servidor.
    // Las entradas son:
    //description: una cadena de caracteres que representa la descripción de la imagen.
    //keywords: una cadena de caracteres que representa las palabras clave asociadas a la imagen.
    //author: un entero que representa el autor de la imagen.
    //owner: un entero que representa el dueño de la imagen.
    //license: un entero que representa la licencia de la imagen.
    //taxons: un entero que representa el taxón asociado a la imagen.
    //model: un objeto de la clase "Model" que se utiliza para agregar atributos al modelo de datos.
    //request: un objeto de la clase "HttpServletRequest" que se utiliza para obtener la ruta del directorio donde
    // se guardarán las imágenes.
    //file: un objeto de la clase "MultipartFile" que representa la imagen que se sube al servidor.
    //El método comprueba si el nombre de archivo es válido y luego crea un directorio para almacenar la imagen.
    // A continuación, guarda la imagen en el servidor y la información de la imagen en la base de datos utilizando
    // la instancia de la clase "ImageService". Por último, devuelve una respuesta HTTP adecuada.
    @PostMapping("/image/saveImageDetails")
    public @ResponseBody ResponseEntity<?> createImage(@RequestParam("description") String description,
                                                       @RequestParam("keywords") String keywords, @RequestParam("author") int author,
                                                       @RequestParam("owner") int owner, @RequestParam("license") int license,
                                                       @RequestParam("taxons") int taxons,
                                                       Model model, HttpServletRequest request
            , final @RequestParam("image") MultipartFile file) {
        try {

            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
            log.info("uploadDirectory:: " + uploadDirectory);
            String fileName = file.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            log.info("FileName: " + file.getOriginalFilename());
            if (fileName == null || fileName.contains("..")) {
                model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
                return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
            }
            String[] keyword = keywords.split(",");
            String[] descriptions = description.split(",");
            Date createDate = new Date();
            log.info("Keywords: " + keyword[0]+" "+filePath);
            log.info("description: " + descriptions[0]);
            log.info("author: " + author);
            log.info("owner: " + owner);
            log.info("license: " + license);
            log.info("taxons: " + taxons);
            try {
                File dir = new File(uploadDirectory);
                if (!dir.exists()) {
                    log.info("Folder Created");
                    dir.mkdirs();
                }
                // Save the file locally
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file.getBytes());
                stream.close();
            } catch (Exception e) {
                log.info("in catch");
                e.printStackTrace();
            }
            byte[] imageData = file.getBytes();
            Image image = new Image();
            image.setKeywords(keyword[0]);
            image.setImage(imageData);
            image.setAuthor(author);
            image.setOwner(owner);
            image.setLicense(license);
            image.setTaxons(taxons);
            image.setDescription(descriptions[0]);
            image.setDate(createDate);
            imageService.saveImage(image);
            log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
            return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception: " + e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la URL "/image/display/{id}".
    // Toma como entrada un parámetro "id" que se obtiene de la URL mediante la anotación @PathVariable.
    // También toma como entrada un objeto HttpServletResponse y un objeto Optional<Image>.
    // El método utiliza el servicio ImageService para obtener la imagen correspondiente al ID proporcionado y
    // la escribe en la respuesta del servlet. Si la imagen no existe, se produce una excepción.
    @GetMapping("/image/display/{id}")
    @ResponseBody
    void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Image> image)
            throws ServletException, IOException {
        log.info("Id :: " + id);
        image = imageService.getImageById(id);
        response.setContentType("image/jpeg");
        response.getOutputStream().write(image.get().getImage());
        response.getOutputStream().close();
    }

    // Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la URL "/image/imageDetails".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la
    // anotación @RequestParam. También toma como entrada un objeto Optional<Image> y un objeto Model.
    // El método utiliza el servicio ImageService para obtener la información de la imagen correspondiente al
    // ID proporcionado y la agrega al modelo. Si la imagen no existe, se redirige al usuario a la página de inicio.

    public static final String REDIRECT_HOME = "redirect:/home";

    @GetMapping("/image/imageDetails")
    String showImageDetails(@RequestParam("id") Long id, Optional<Image> image, Model model) {
        try {
            log.info("Id :: " + id);
            if (id != 0) {
                image = imageService.getImageById(id);

                log.info("products :: " + image);
                if (image.isPresent()) {
                    model.addAttribute("id", image.get().getId());
                    model.addAttribute("description", image.get().getDescription());
                    model.addAttribute("keywords", image.get().getKeywords());
                    model.addAttribute("author", image.get().getAuthor());
                    model.addAttribute("owner", image.get().getAuthor());
                    model.addAttribute("license", image.get().getAuthor());
                    model.addAttribute("taxons", image.get().getAuthor());
                    return "imagedetails";
                }
                return REDIRECT_HOME;
            }
            return REDIRECT_HOME;
        } catch (Exception e) {
            e.printStackTrace();
            return REDIRECT_HOME;
        }
    }

    // Este método utiliza la anotación @GetMapping para mapear una solicitud GET a la URL "/image/show".
    // Toma como entrada un objeto Model. El método utiliza el servicio ImageService para obtener todas las
    // imágenes activas y las agrega al modelo. Luego devuelve la vista "images".
    @GetMapping("/image/show")
    String show(Model map) {
        List<Image> images = imageService.getAllActiveImages();
        map.addAttribute("images", images);
        return "images";
    }


    //este método utiliza la anotación @GetMapping para mapear una solicitud GET a la URL "/deleteProd/{id}".
    // Toma como entrada un parámetro "id" que se obtiene de la URL mediante la anotación @PathVariable.
    // El método utiliza el servicio ImageService para eliminar la imagen correspondiente al ID
    // proporcionado y luego redirige al usuario a la vista "images".
    @GetMapping("/deleteProd/{id}")
    public String deleteImage(@PathVariable("id") Long id)
    {

        imageService.deleteProductById(id);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeKeywords".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newKeywords" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar las palabras clave de la imagen
    // correspondiente al ID proporcionado y luego redirige al usuario a la vista "images".
    @PostMapping("/changeKeywords")
    public String changeKeywords(@RequestParam("id") Long id,
                                 @RequestParam("newKeywords") String name)
    {
        imageService.changeImageKeywords(id, name);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeDescription".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newDescription" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar la descripción de la imagen
    // correspondiente al ID proporcionado y luego redirige al usuario a la vista "images".
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        imageService.changeImageDescription(id, description);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeAuthor".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newAuthor" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar el autor de la imagen
    @PostMapping("/changeAuthor")
    public String changeAuthor(@RequestParam("id") Long id ,
                              @RequestParam("newAuthor") int price)
    {
        imageService.changeImageAuthor(id, price);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeOwner".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newOwner" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar el owner de la imagen
    @PostMapping("/changeOwner")
    public String changeOwner(@RequestParam("id") Long id ,
                              @RequestParam("newOwner") int price)
    {
        imageService.changeImageOwner(id, price);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeLicense".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newLicense" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar el license de la imagen
    @PostMapping("/changeLicense")
    public String changeLicense(@RequestParam("id") Long id ,
                              @RequestParam("newLicense") int price)
    {
        imageService.changeImageLicense(id, price);
        return "redirect:/image/show";
    }

    // Este método utiliza la anotación @PostMapping para mapear una solicitud POST a la URL "/changeTaxons".
    // Toma como entrada un parámetro "id" que se obtiene de los parámetros de solicitud mediante la anotación
    // @RequestParam y un parámetro "newTaxons" que se obtiene de los parámetros de solicitud mediante la misma
    // anotación. El método utiliza el servicio ImageService para actualizar el taxons de la imagen
    @PostMapping("/changeTaxons")
    public String changeTaxons(@RequestParam("id") Long id ,
                              @RequestParam("newTaxons") int price)
    {
        imageService.changeImageTaxons(id, price);
        return "redirect:/image/show";
    }

}
