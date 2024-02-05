package com.trifulcas.Repository;

import java.util.List;

<<<<<<< HEAD
import com.trifulcas.Models.Espectadores;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EspectadoresRepository extends JpaRepository<Espectadores, Integer> {

    static Iterable<Object> findByespectadoresId(int id) {
        return null;
    }

    static Iterable<Object> findByNameContaining(String name) {
        return null;
    }

    List<Espectadores> findByEspectadoresId(int id);
=======
import com.trifulcas.Models.EspectadoresModels;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EspectadoresRepository extends JpaRepository<EspectadoresModels, Integer> {
    // Busco las categorías cuyo nombre contenga una cadena
    List<EspectadoresModels> findByNameContaining(String name);

    // Busco las categorías cuya propiedad 'Films' tengan un id 'FilmId'
    List<EspectadoresModels> findByFilmsFilmId(int id);
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
}