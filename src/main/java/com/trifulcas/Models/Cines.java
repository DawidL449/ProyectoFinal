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

public class Cines implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", nullable=false)
    private String nombre;
    @Column(name="numero")

    private int numero;

    public Cines(Long idsalas, String nombre, int numero) {
        this.id = idsalas;
        this.nombre = nombre;
        this.numero = numero;

    }

    public Long getIdsalas() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setIdsalas(Long idsalas) {
        this.id = idsalas;
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
                "idsalas=" + id +
                ", nombre='" + nombre + '\'' +
                ", numero=" + numero +
                '}';
    }
}