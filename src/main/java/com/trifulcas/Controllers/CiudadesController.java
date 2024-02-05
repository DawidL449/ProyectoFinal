package com.trifulcas.Controllers;

<<<<<<< HEAD
import com.trifulcas.Models.Cines;
import com.trifulcas.Models.Ciudades;
=======
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.CiudadesModels;
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
import com.trifulcas.Repository.CiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/ciudades")
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
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
public class CiudadesController {
    @Autowired
    CiudadesRepository ciudadesRepository;

<<<<<<< HEAD
    @GetMapping("/ciudades")
    public ResponseEntity<List<Ciudades>> getAll() {
        List<Ciudades> res = new ArrayList<>();
        ciudadesRepository.findAll().forEach(res::add);
        if (res.isEmpty()) {
            ciudadesRepository.findAll().forEach(res::add);
        } else {
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("film/{id}/ciudades")
    public ResponseEntity<List<Ciudades>> getAllByFilm(@PathVariable("id") long id) {
        List<Ciudades> res = new ArrayList<>();
        Optional<Ciudades> ciudades = ciudadesRepository.findById(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/ciudades/{id}")
    public ResponseEntity<Ciudades> getCategory(@PathVariable("id") long id) {
        Ciudades ciudades = ciudadesRepository.findById((long) id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (ciudades == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ciudades, HttpStatus.OK);
        }
    }
    @PutMapping("/ciudades/{id}")
    public ResponseEntity<Ciudades> updateCity(@PathVariable("id") Long id, @RequestBody Ciudades ciudades) {
        Ciudades temp = ciudadesRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ciudadesRepository.save(temp), HttpStatus.OK);
    }
    @DeleteMapping("/ciudades/{id}/ciudades")
    public ResponseEntity<HttpStatus> deleteCiudadesCountry(@PathVariable("id") Long id) {
        // No recupero el country, me basta con saber que existe
        if (!ciudadesRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ciudadesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<HttpStatus> deletefilm(@PathVariable("id")Long id) {
        ciudadesRepository.deleteAllById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
=======
    @GetMapping("/category")
    public ResponseEntity<List<CiudadesModels>> getAll(@RequestParam(required = false) String name) {
        List<CiudadesModels> res = new ArrayList<>();
        if (name == null) {

        } else {
            CiudadesRepository.findByNameContaining(name).forEach(res::add);
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/addcat")
    public String addCategory(@Validated CiudadesModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        return null;
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CiudadesModels> getCategory(@PathVariable("id") int id) {
        CiudadesModels ciudadesModels = (CiudadesModels) CiudadesModels.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (ciudadesModels == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ciudadesModels, HttpStatus.OK);
        }
    }

    @PostMapping("/ciudades")
    public ResponseEntity<CiudadesModels> addCategory(@RequestBody CiudadesModels ciudadesModels) {
        CiudadesModels temp = CiudadesModels.save(new CiudadesModels(ciudadesModels.getName()));
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CiudadesModels> updateCategory(@PathVariable("id") int id, @RequestBody CiudadesModels ciudadesModels) {
        CiudadesModels temp = ciudadesRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            temp.setName(ciudadesRepository());
            return new ResponseEntity<>(ciudadesRepository.save(temp), HttpStatus.OK);

        }
    }

    private String ciudadesRepository() {
        return null;
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        ciudadesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
