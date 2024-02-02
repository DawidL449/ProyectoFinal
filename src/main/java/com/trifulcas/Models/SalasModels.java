package com.trifulcas.Models;

import jakarta.persistence.Column;

import java.io.Serializable;


public class SalasModels implements Serializable{
    private Long idsalas;

    @Column(name="nombre")
    private String nombre;
    @Column(name="numero")

    private int numero;

    public SalasModels(Long idsalas) {
        this.idsalas = idsalas;
    }

    public SalasModels(String nombre) {
        this.nombre = nombre;
    }

    public SalasModels(int numero) {
        this.numero = numero;


    }

    @Override
    public String toString() {
        return "SalasModels{" +
                "idsalas=" + idsalas +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                '}';
    }
}

