package com.trifulcas.Controllers;

import com.trifulcas.Models.CinesModels;
import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Repository.CinesRepository;
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
public class CinesController {

    @Autowired
    CinesRepository cinesRepository;
    private Object CinesRepository;
    private Object cines;

    @GetMapping("/index")
    public String getAll(Model model) {
        model.addAttribute("categories", CinesController.findAll());

        return "index";
    }

    private static Object findAll() {
        return null;
    }

    @GetMapping("/add")
    public String addCat(CinesController Peliculas) {
        return "add";
    }

    @PostMapping("/addcat")
    public String addCategory(@Validated CiudadesModels Ciudades, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        CinesController.save(Ciudades);
        return "redirect:/cat/index";
    }

    @GetMapping("/edit/{id}")
    public String editPeliculas(@PathVariable("id") int id, Model model) {
        CiudadesModels peliculas = (CiudadesModels) CinesController.findById(id).get();
        model.addAttribute("ciudades", CinesRepository);
        return "update";
    }

    private static ThreadLocal<Object> findById(int id) {
        return null;
    }


    @PostMapping("/updatecat/{id}")
    public String updateFilms(@PathVariable("id") int id, @Validated PeliculasController cines, BindingResult result,
                              Model model) {

        if (result.hasErrors()) {
            return "update";
        }
        CinesController.save(cines);
        return "redirect:/cat/index";

    }

    private static void save(Object cines) {
    }



    private static void save(CinesModels cines) {
    }

    private void setCategoryId(int id) {
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable("id") int id) {
        CinesController.deleteById(id);
        return "redirect:/cat/index";
    }

    private static void deleteById(int id) {

    }
}