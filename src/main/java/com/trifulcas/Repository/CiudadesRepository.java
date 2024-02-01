package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.CiudadesModels;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CiudadesRepository extends JpaRepository<CiudadesModels, Integer> {
    static Iterable<Object> findByCiudadesModelsId(int id) {
        return null;
    }

    // Busco las categorías cuyo nombre contenga una cadena
    static List<CiudadesModels> findByNameContaining(String name);

    // Busco las categorías cuya propiedad 'Films' tengan un id 'FilmId'
    static List<CiudadesModels> findByFilmsFilmId(int id) {
        return null;
    }
}