package com.trifulcas.Controllers;

import com.trifulcas.Models.Cines;
import com.trifulcas.Models.Peliculas;
import com.trifulcas.Repository.CinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cines")
public class CinesController {
    @Autowired
    CinesRepository cinesRepository;

    @GetMapping("/cines")
    public ResponseEntity<List<Cines>> getAll(@RequestParam(required = false) String name) {
        List<Cines> res = new ArrayList<>();
        if (name == null) {
            cinesRepository.findAll().forEach(res::add);
        } else {
            cinesRepository.findByNameContaining(name).forEach(res::add);
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/cines/{id}")
    public ResponseEntity<Cines> getPeliculas(@PathVariable("id") int id) {
        Cines cines = cinesRepository.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Country not found"));
                .orElse(null);
        if (cines == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cines, HttpStatus.OK);
        }
    }
    @GetMapping("film/{id}/cines")
    public ResponseEntity<List<Cines>> getAllByFilm(@PathVariable("id") int id) {
        List<Cines> res = new ArrayList<>();
        Optional<Cines> espectadores = cinesRepository.findById(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PostMapping("/cines/{id}/cines")
    public ResponseEntity<Cines> addCity(@PathVariable("id") int id, @RequestBody Cines city) {
        Cines cines = cinesRepository.findById(id).orElse(null);
        if (cines == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return null;
    }
    @PostMapping("/film/{id}/film")
    public ResponseEntity<Cines> addfilm(@PathVariable("id") int id, @RequestBody Peliculas film) {
        Cines cines = cinesRepository.findById(id).orElse(null);
        if (cines == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        Peliculas temp = new Peliculas(cines.getId(),film);


        return null;
    }



    @PutMapping("/cines/{id}")
    public ResponseEntity<Cines> updatefilm(@PathVariable("id") int id, @RequestBody Peliculas film) {
        Cines temp = cinesRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return null;
    }
    @DeleteMapping("/cines/{id}/city")
    public ResponseEntity<HttpStatus> deleteCityCountry(@PathVariable("id") int id) {

        if (!cinesRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            cinesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
    @DeleteMapping("/cines/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable("id") int id) {
        cinesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


