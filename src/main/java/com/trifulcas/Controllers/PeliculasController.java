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




@RestController
@RequestMapping("/api")
public class PeliculasController {
    @Autowired
    PeliculasRepository PeliculasRepository;
    private com.trifulcas.Models.Peliculas Peliculas;

    @GetMapping("/peliculas")
    public ResponseEntity<List<EspectadoresModels>> getAll(@RequestParam(required = false) String name) {
        List<EspectadoresModels> res = new ArrayList<>();
        if (name == null) {

        } else {
            EspectadoresRepository.findByNameContaining(name).forEach(res::add);
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
    public ResponseEntity<HttpStatus> deletefilm(@PathVariable("id") int id) {
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


    @PostMapping("/addcat")
    public String addpeliculas(@Validated PeliculasModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        return null;
    }

    @GetMapping("/peliculas/{id}")
        public ResponseEntity<PeliculasModels> getCategory(@PathVariable("id") int id) {
        PeliculasModels peliculasModels = PeliculasRepository.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Category not found"));
                .orElse(null);
        if (PeliculasModels == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(PeliculasModels, HttpStatus.OK);
        }
    }

    @PostMapping("/peliculas")
    public ResponseEntity<Peliculas> addCategory(@RequestBody Peliculas ciudadesModels) {
        Peliculas temp = Peliculas.save(new Peliculas(Peliculas.getName()));
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<EspectadoresModels> updateCategory(@PathVariable("id") int id, @RequestBody Peliculas peliculas) {
        PeliculasModels temp = PeliculasRepository.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            temp.setName(PeliculasRepository());
            return new ResponseEntity<>(PeliculasRepository.save(temp), HttpStatus.OK);

        }
    }

    private String PeliculasRepository() {
        return null;
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        EspectadoresRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
