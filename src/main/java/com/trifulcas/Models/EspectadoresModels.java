package com.trifulcas.Models;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class EspectadoresModels implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long idespectadores;
    @Column private int cantidad;
    @Column private String genero;
    @Column private int edad;

    @Column private String nombre;

    public Long getIdespectadores() {
        return idespectadores;
    }

    public void setIdespectadores(Long idespectadores) {
        this.idespectadores = idespectadores;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "EspectadoresModels{" +
                "idespectadores=" + idespectadores +
                ", cantidad=" + cantidad +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
