package com.trifulcas.Repository;

import java.util.List;


import com.trifulcas.Models.Cines;

import org.springframework.data.jpa.repository.JpaRepository;
public interface CinesRepository extends JpaRepository<Cines, Integer> {
    List<Cines> findByNameContaining(String name);

    List<Cines> findCategoryByFilmsFilmId(int id);

    Iterable<Object> findBycinesFilmId(int id)

