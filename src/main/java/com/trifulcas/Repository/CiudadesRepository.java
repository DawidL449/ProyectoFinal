package com.trifulcas.Repository;

import java.util.List;
import java.util.Optional;

import com.trifulcas.Models.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;


<<<<<<< HEAD
public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {
    static Iterable<Object> findByCiudadesModelsId(int id) {
        return null;
    }

    static List<Ciudades> findByNameContaining(String name) {
        return null;
    }

    static List<Ciudades> findByCiudadesFilmId(int id) {
        return null;
    }

    static Iterable<Object> findBycinesFilmId(int id) {
        return null;
    }

    Iterable<Object> findCategoryByFilmsFilmId(int id);

    void deleteAllById(Long id);

    Optional<Object> findById(Class<? extends String> aClass);
=======
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
>>>>>>> 25e526a8709a323ed687eb4b0ba91ad0bcd51da7
}