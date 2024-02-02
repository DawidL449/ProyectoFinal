package com.trifulcas.Controllers;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.PeliculasModels;
import com.trifulcas.Repository.PeliculasRepository;
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
    PeliculasRepository peliculasRepository;
    private com.trifulcas.Models.PeliculasModels PeliculasModels;

    public PeliculasController(Object name) {

    }

    @GetMapping("/peliculas")
        public ResponseEntity<List<PeliculasModels>> getAll(@RequestParam(required = false) String name) {
        List<PeliculasModels> res = new ArrayList<>();
        if (name == null) {

        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    private static Iterable<Object> findByNameContaining(String name) {
        return null;
    }

    @PostMapping("/addcat")
    public String addCategory(@Validated PeliculasModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        return null;
    }

    @GetMapping("/espectadores/{id}")
    public ResponseEntity<PeliculasModels> getCategory(@PathVariable("id") int id) {
            PeliculasModels ciudadesModels = (PeliculasModels) PeliculasController.findById(id)
                // .orElseThrow(()->new ResourceNotFoundException("Peliculas not found"));
                .orElse(null);
        if (ciudadesModels == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(PeliculasModels, HttpStatus.OK);
        }
    }

    @PostMapping("/ciudades")
    public ResponseEntity<PeliculasModels> addCategory(@RequestBody PeliculasModels espectadoresModels) {
            PeliculasModels temp = PeliculasController.save(new PeliculasController(peliculasRepository.getName()));
        return new ResponseEntity<>(temp, HttpStatus.CREATED);
    }

    private static com.trifulcas.Models.PeliculasModels save(PeliculasController peliculasController) {
        return null ;
    }

    private static com.trifulcas.Models.PeliculasModels save(com.trifulcas.Models.PeliculasModels peliculasController) {
        return null;
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<PeliculasModels> updateCategory(@PathVariable("id") int id, @RequestBody PeliculasModels ciudadesModels) {
            PeliculasModels temp = (com.trifulcas.Models.PeliculasModels) PeliculasController.findById(id).orElse(null);
        if (temp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            temp.setName(PeliculasRepository());
            return new ResponseEntity<>(PeliculasController.save(temp), HttpStatus.OK);

        }
    }

    private static ScopedValue<Object> findById(int id) {
        return null;
    }


    private String PeliculasRepository() {
        return null;
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") int id) {
        PeliculasController.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private static void deleteById(int id) {
    }
}