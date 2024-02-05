package com.trifulcas.Repository;

import java.util.List;
import java.util.Optional;

import com.trifulcas.Models.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {
    static Iterable<Object> findByCiudadesModelsId(int id) {
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
}


