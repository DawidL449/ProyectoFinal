package com.trifulcas.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name="cines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CinesModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcines;
    @Column(name="nombre")
    private String nombre;
    @Column(name="salas")
    private String salas;


    public CinesModels(String nombre,int idcines,String salas) {
        this.nombre = nombre;
        this.idcines = (long) idcines;
        this.salas = salas;
    }

    public Long getIdcines() {
        return idcines;
    }

    public String getNombre() {
        return nombre;

    }

    public String getSalas() {
        return salas;


    }


    public void setSalas(String salas) {
        this.salas = salas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdcines(Long idcines) {
        this.idcines = idcines;
    }

    @Override
    public String toString() {
        return "CinesModels{" +
                "idcines=" + idcines +
                ", nombre='" + nombre + '\'' +
                ", salas='" + salas + '\'' +
                '}';
    }
}