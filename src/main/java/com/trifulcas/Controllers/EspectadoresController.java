package com.trifulcas.Controllers;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.model.Model;
import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Models.EspectadoresModels;
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
        }
        if (res.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

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