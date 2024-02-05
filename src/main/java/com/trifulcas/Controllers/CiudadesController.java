package com.trifulcas.Controllers;

import com.trifulcas.Models.Cines;
import com.trifulcas.Models.Ciudades;
import com.trifulcas.Repository.CiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/ciudades")
public class CiudadesController {
    @Autowired
    CiudadesRepository ciudadesRepository;

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
