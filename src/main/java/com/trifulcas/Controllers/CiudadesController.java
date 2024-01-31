package com.trifulcas.Controllers;

import com.trifulcas.Models.CinesModels;
import com.trifulcas.Models.CiudadesModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/cat")
public class CiudadesController {

    @Autowired
    CiudadesController CiudadesRepository;
    private CiudadesModels Ciudades;

    @GetMapping("/index")
    public String getAll(Model model) {
        model.addAttribute("categories", CiudadesRepository.findAll());

        return "index";
    }

    Object findAll() {
        return null;
    }

    @GetMapping("/add")
    public String addCat(PeliculasController Peliculas) {
        return "add";
    }

    @PostMapping("/addcat")
    public String addCategory(@Validated CiudadesModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        CiudadesRepository.save(Ciudades);
        return "redirect:/cat/index";
    }

    protected void save(CinesModels ciudades) {
    }

    @GetMapping("/edit/{id}")
    public String editciudades(@PathVariable("id") int id, Model model) {
        CiudadesModels ciudades = (CiudadesModels) CiudadesController.findById(id).get();
        model.addAttribute("ciudades", CiudadesRepository);
        return "update";
    }

    private static ThreadLocal<Object> findById(int id) {
        return null;
    }


    @PostMapping("/updatecat/{id}")
    public String updateFilms(@PathVariable("id") int id, @Validated PeliculasController peliculas, BindingResult result,
                              Model model) {
        CiudadesModels.setCategoryId(id);
        if (result.hasErrors()) {
            return "update";
        }
        CiudadesRepository.save(Ciudades);
        return "redirect:/cat/index";

    }


    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable("id") int id) {
        CiudadesRepository.deleteById(id);
        return "redirect:/cat/index";
    }

    void deleteById(int id) {

    }
    }
