package com.trifulcas.Controllers;

<<<<<<< HEAD
import com.trifulcas.Models.Espectadores;
import com.trifulcas.Models.Peliculas;
=======
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Models.EspectadoresModels;
import com.trifulcas.Repository.CiudadesRepository;
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
import com.trifulcas.Repository.EspectadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/espectadores")
public class EspectadoresController {
    @Autowired
    EspectadoresRepository espectadoresRepository;

    @GetMapping("/espectadores")
    public ResponseEntity<List<Espectadores>> getAll() {
        List<Espectadores> res = new ArrayList<>();
        espectadoresRepository.findAll().forEach(res::add);
        if (res.isEmpty()) {
            espectadoresRepository.findAll().forEach(res::add);
        } else {
=======
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class EspectadoresController {
    @Autowired
    EspectadoresRepository EspectadoresRepository;
    private com.trifulcas.Models.EspectadoresModels EspectadoresModels;

    @GetMapping("/espectadores")
    public ResponseEntity<List<EspectadoresModels>> getAll(@RequestParam(required = false) String name) {
        List<EspectadoresModels> res = new ArrayList<>();
        if (name == null) {

        } else {
            EspectadoresRepository.findByNameContaining(name).forEach(res::add);
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
<<<<<<< HEAD
    @GetMapping("/espectadores/{id}")
    public ResponseEntity<Espectadores> getCity(@PathVariable("id") int id) {
        Espectadores espectadores = espectadoresRepository.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Country not found"));
                .orElse(null);
        if (espectadores == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(espectadores, HttpStatus.OK);
        }
    }

    @GetMapping("espectadores/{id}/espectadores")
    public ResponseEntity<List<Espectadores>> getAllByFilm(@PathVariable("id") int id) {
        List<Espectadores> res = new ArrayList<>();
        Optional<Espectadores> espectadores = espectadoresRepository.findById(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/espectadores/{id}/espectadores")
    public ResponseEntity<Espectadores> get(@PathVariable("id") int id) {
        Espectadores cines = espectadoresRepository.findById((int) id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (cines == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cines, HttpStatus.OK);
        }

    }


    @PostMapping("/espectadores/{id}/espectadores")
    public ResponseEntity<Peliculas> addfilm(@PathVariable("id") int id, @RequestBody Peliculas film) {
        Espectadores espectadores = espectadoresRepository.findById(id).orElse(null);
        if (espectadores == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Peliculas temp = new Peliculas(espectadores.getIdespectadores(), film);


        return null;
    }

    @PutMapping("/espectadores/{id}")
    public ResponseEntity<Espectadores> updateCity(@PathVariable("id") int id, @RequestBody Espectadores espectadores) {
        Espectadores temp = espectadoresRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        temp.setGenero(espectadores.getGenero());
        if (espectadores.getGenero() != null) {
            Espectadores espectadores1 = espectadoresRepository.findById(espectadores.getEdad()).orElse(null);
            if (espectadores != null) {
                temp.getIdespectadores();
            }
        }
        return new ResponseEntity<>(espectadoresRepository.save(temp), HttpStatus.OK);
    }
    @DeleteMapping("/espectadores/{id}/city")
    public ResponseEntity<HttpStatus> deleteCityfilm(@PathVariable("id") int id) {
        if (!espectadoresRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            espectadoresRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/espectadores/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") int id) {
        espectadoresRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

=======

    @PostMapping("/addcat")
    public String addCategory(@Validated EspectadoresModels Espectadores, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        return null;
    }

    @GetMapping("/espectadores/{id}")
    public ResponseEntity<EspectadoresModels> getCategory(@PathVariable("id") int id) {
        CiudadesModels ciudadesModels = (CiudadesModels) CiudadesModels.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (ciudadesModels == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
                return new ResponseEntity<>(EspectadoresModels, HttpStatus.OK);
        }
    }

    @PostMapping("/ciudades")
    public ResponseEntity<EspectadoresModels> addCategory(@RequestBody CiudadesModels ciudadesModels) {
        EspectadoresModels temp = CiudadesModels.save(new EspectadoresModels(ciudadesModels.getName()));
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<EspectadoresModels> updateCategory(@PathVariable("id") int id, @RequestBody CiudadesModels ciudadesModels) {
        EspectadoresModels temp = EspectadoresRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            temp.setName(EspectadoresRepository());
            return new ResponseEntity<>(EspectadoresRepository.save(temp), HttpStatus.OK);

        }
    }

    private String EspectadoresRepository() {
        return null;
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
       EspectadoresRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
