package com.trifulcas.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.*;

@Getter
@Entity
@Table
@Data
public class EspectadoresModels {
    private Long id;
    private String Nombre;
    private String Descripcion;
    private String Genero;

    public static EspectadoresModels save(CinesModels cinesModels) {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getName() {
        return null;
    }
}
