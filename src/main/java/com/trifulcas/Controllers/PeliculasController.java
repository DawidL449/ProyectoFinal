package com.trifulcas.Controllers;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Models.EspectadoresModels;
import com.trifulcas.Models.PeliculasModels;
import com.trifulcas.Repository.CiudadesRepository;
import com.trifulcas.Repository.EspectadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PeliculasController {
    @Autowired
    PeliculasRepository PeliculasRepository;
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

=======

    @PostMapping("/addcat")
    public String addpeliculas(@Validated PeliculasModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        return null;
    }

    @GetMapping("/peliculas/{id}")
        public ResponseEntity<PeliculasModels> getCategory(@PathVariable("id") int id) {
        PeliculasModels ciudadesModels = PeliculasRepository.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (PeliculasModels == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(PeliculasModels, HttpStatus.OK);
        }
    }

    @PostMapping("/peliculas")
    public ResponseEntity<PeliculasModels> addCategory(@RequestBody CiudadesModels ciudadesModels) {
        EspectadoresModels temp = CiudadesModels.save(new EspectadoresModels(ciudadesModels.getName()));
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<EspectadoresModels> updateCategory(@PathVariable("id") int id, @RequestBody CiudadesModels ciudadesModels) {
        PeliculasModels temp = PeliculasRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            temp.setName(EspectadoresRepository());
            return new ResponseEntity<>(PeliculasRepository.save(temp), HttpStatus.OK);

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
