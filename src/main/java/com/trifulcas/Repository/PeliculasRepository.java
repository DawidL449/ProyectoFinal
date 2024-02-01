package com.trifulcas.Repository;

import java.util.List;


import com.trifulcas.Models.PeliculasModels;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PeliculasRepository extends JpaRepository<PeliculasModels, Integer> {
    List<PeliculasModels> findByPeliculasContaining(String peliculas);
}