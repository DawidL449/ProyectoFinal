package com.trifulcas.Repository;

import java.util.List;
import com.trifulcas.Models.Espectadores;
import com.trifulcas.Models.Salas;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SalasRepository extends JpaRepository<Espectadores, Integer> {
    List<Salas> findByCiudadContaining(String salas);

    void setCategoryId(int id);
}