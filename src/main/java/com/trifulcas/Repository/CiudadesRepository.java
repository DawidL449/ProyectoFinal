package com.trifulcas.Repository;

import java.util.List;

import com.trifulcas.Models.CiudadesModels;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CiudadesRepository extends JpaRepository<CiudadesModels, Integer> {

    List<CiudadesModels> findByCiudadContaining(String ciudad);
}