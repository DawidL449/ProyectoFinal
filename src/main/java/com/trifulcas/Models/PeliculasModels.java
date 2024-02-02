package com.trifulcas.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table(name="cines")
@AllArgsConstructor
@Getter
@Setter
public class PeliculasModels implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idpeliculas;
    @Column(name="nombre")
    private String nombre;
    @Column(name="genero")
    private String genero;
    @Column(name="año")
    private int año;

    @Column(name="lanzamiento")
    private String lanzamiento;

    public PeliculasModels() {
    }
    public PeliculasModels(Long idpeliculas,String genero,String nombre,String lanzamiento) {
        this.idpeliculas = idpeliculas;
        this.genero=genero;
        this.nombre = nombre;
        this.año = año;
        this.lanzamiento = lanzamiento;
    }

    public Long getIdpeliculas() {
        return idpeliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getAño() {
        return año;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setIdpeliculas(Long idpeliculas) {
        this.idpeliculas = idpeliculas;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String toString() {
        return "PeliculasModels{" +
                "idpeliculas=" + idpeliculas +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", año=" + año +
                ", lanzamiento='" + lanzamiento + '\'' +
                '}';
    }
}