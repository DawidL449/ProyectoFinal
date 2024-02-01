package com.trifulcas.Controllers;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Repository.CiudadesRepository;
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
public class CiudadesController {
    @Autowired
    CiudadesRepository ciudadesRepository;

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