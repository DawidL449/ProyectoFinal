package com.trifulcas.Repository;

import java.util.List;

<<<<<<< HEAD
import com.trifulcas.Models.Cines;
=======
import com.trifulcas.Controllers.PeliculasController;
import com.trifulcas.Models.CinesModels;
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
import org.springframework.data.jpa.repository.JpaRepository;
public interface CinesRepository extends JpaRepository<Cines, Integer> {
    List<Cines> findByNameContaining(String name);

    List<Cines> findCategoryByFilmsFilmId(int id);

    Iterable<Object> findBycinesFilmId(int id);

<<<<<<< HEAD
=======
public interface CinesRepository extends JpaRepository<CinesModels, Integer> {

    static void save(PeliculasController ciudades) {
    }

    List<CinesModels> findByCiudadContaining(String cines);
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
}