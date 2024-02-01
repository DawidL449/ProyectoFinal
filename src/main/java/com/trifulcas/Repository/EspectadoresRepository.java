package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.EspectadoresModels;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EspectadoresRepository extends JpaRepository<EspectadoresModels, Integer> {
    // Busco las categorías cuyo nombre contenga una cadena
    List<EspectadoresModels> findByNameContaining(String name);

    // Busco las categorías cuya propiedad 'Films' tengan un id 'FilmId'
    List<EspectadoresModels> findByFilmsFilmId(int id);
}