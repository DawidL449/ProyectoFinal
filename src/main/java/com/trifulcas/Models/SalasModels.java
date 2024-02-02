package com.trifulcas.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="cines")
@NoArgsConstructor
@Getter
@Setter
public class SalasModels implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsalas;

    @Column(name="nombre")
    private String nombre;
    @Column(name="numero")

    private int numero;

    public SalasModels(Long idsalas,String nombre,int numero) {
        this.idsalas = idsalas;
        this.nombre = nombre;
        this.numero = numero;

    }

    public Long getIdsalas() {
        return idsalas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }


    public void setIdsalas(Long idsalas) {
        this.idsalas = idsalas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
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

