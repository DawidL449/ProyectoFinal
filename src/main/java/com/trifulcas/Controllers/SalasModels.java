package com.trifulcas.Controllers;

import com.trifulcas.Models.CiudadesModels;
import com.trifulcas.Models.PeliculasModels;
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
public class SalasModels {

    @Autowired
    SalasModels SalasRepository;

    @GetMapping("/index")
    public String getAll(Model model) {
        model.addAttribute("categories", SalasRepository.findAll());

        return "index";
    }

    private Object findAll() {
        return null;
    }

    @GetMapping("/add")
    public String addCat(EspectadoresController Peliculas) {
        return "add";
    }

    @PostMapping("/addcat")
    public String addCategory(@Validated PeliculasModels Peliculas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        SalasRepository.save(Peliculas);
        return "redirect:/cat/index";
    }

    @GetMapping("/edit/{id}")
    public String editPeliculas(@PathVariable("id") int id, Model model) {
        PeliculasModels peliculas = (PeliculasModels) SalasModels.findById(id).get();
        model.addAttribute("ciudades", SalasRepository);
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
        SalasRepository.save(peliculas);
        return "redirect:/cat/index";

    }

    private void save(PeliculasController peliculas) {

    }

    private void save(PeliculasModels peliculas) {
    }

    private void setCategoryId(int id) {
    }

    @GetMapping("/delete/{id}")
    public String deleteCat(@PathVariable("id") int id) {
        SalasRepository.deleteById(id);
        return "redirect:/cat/index";
    }

    private void deleteById(int id) {

    }
}
