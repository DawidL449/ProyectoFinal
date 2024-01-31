package com.trifulcas.Models;



import javax.persistence.*;

import lombok.*;

@Getter
@Table
@Data
public class PeliculasModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Nombre;
    private String Descripcion;
    private String Genero;

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
}
