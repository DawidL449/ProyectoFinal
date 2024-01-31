package com.trifulcas.Repository;

import java.util.List;
import com.trifulcas.Models.EspectadoresModels;
import com.trifulcas.Models.SalasModels;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SalasRepository extends JpaRepository<EspectadoresModels, Integer> {
    List<SalasModels> findByCiudadContaining(String salas);

    void setCategoryId(int id);
}