package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.EspectadoresModels;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EspectadoresRepository extends JpaRepository<EspectadoresModels, Integer> {
    List<EspectadoresModels> findByNameContaining(String name);

    List<EspectadoresModels> findByEspectadoresId(int id);
}