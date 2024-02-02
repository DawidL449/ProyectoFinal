package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.CiudadesModels;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CiudadesRepository extends JpaRepository<CiudadesModels, Integer> {
    static Iterable<Object> findByCiudadesModelsId(int id) {
        return null;
    }

    static List<CiudadesModels> findByNameContaining(String name) {
        return null;
    }

    static List<CiudadesModels> findByCiudadesFilmId(int id) {
        return null;
    }
}