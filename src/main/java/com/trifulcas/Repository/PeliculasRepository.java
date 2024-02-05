package com.trifulcas.Repository;

import java.util.List;


import com.trifulcas.Models.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PeliculasRepository extends JpaRepository<Peliculas, Integer> {
    List<Peliculas> findByPeliculasContaining(String peliculas);

    Object getName();

    void deleteByCountryCountryId(int id);
}