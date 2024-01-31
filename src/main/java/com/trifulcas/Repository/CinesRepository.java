package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.CinesModels;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CinesRepository extends JpaRepository<CinesModels, Integer> {

    List<CinesModels> findByCiudadContaining(String cines);
}