package com.trifulcas.Controllers;

import com.trifulcas.Models.Peliculas;
import com.trifulcas.Repository.PeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/peliculas")
public class PeliculasController {
    @Autowired
    PeliculasRepository peliculasRepository;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Peliculas>> getAll() {
        List<Peliculas> res = new ArrayList<>();
        peliculasRepository.findAll().forEach(res::add);
        if (res.isEmpty()) {
            peliculasRepository.findAll().forEach(res::add);
        } else {
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/peliculas/{id}")
    public ResponseEntity<Peliculas> getCity(@PathVariable("id") int id) {
        Peliculas peliculas = peliculasRepository.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Country not found"));
                .orElse(null);
        if (peliculas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        }
    }

    @GetMapping("film/{id}/peliculas")
    public ResponseEntity<List<Peliculas>> getAllByFilm(@PathVariable("id") int id) {
        List<Peliculas> res = new ArrayList<>();
        Optional<Peliculas> espectadores = peliculasRepository.findById(id);
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/peliculas/{id}")
    public ResponseEntity<Peliculas> getCategory(@PathVariable("id") int id) {
        Peliculas peliculas = peliculasRepository.findById((int) id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (peliculas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(peliculas, HttpStatus.OK);
        }
    }


    @PostMapping("/film/{id}/film")
    public ResponseEntity<Peliculas> addfilm(@PathVariable("id") int id, @RequestBody Peliculas film) {
        Peliculas peliculas = peliculasRepository.findById(id).orElse(null);
        if (peliculas == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Peliculas temp = new Peliculas(peliculas.getIdpeliculas(), film);
        return new ResponseEntity<>(peliculasRepository.save(temp), HttpStatus.CREATED);

    }

    @PutMapping("/peliculas/{id}")
    public ResponseEntity<Peliculas> updatefilm(@PathVariable("id") int id, @RequestBody Peliculas film) {
        Peliculas temp = peliculasRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return null;
    }

    @DeleteMapping("/peliculas/{id}/city")
    public ResponseEntity<HttpStatus> deleteCityfilm(@PathVariable("id") int id) {
        if (!peliculasRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            peliculasRepository.deleteByCountryCountryId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
    @DeleteMapping("/peliculas/{id}")
    public ResponseEntity<HttpStatus> deletefilm(@PathVariable("id") int id) {
        peliculasRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

