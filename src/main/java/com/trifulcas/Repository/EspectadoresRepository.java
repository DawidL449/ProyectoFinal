package com.trifulcas.Repository;

import java.util.List;

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
}