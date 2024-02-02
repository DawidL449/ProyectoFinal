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
public class EspectadoresModels implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long idespectadores;
    @Column private int cantidad;
    @Column private String genero;
    @Column private int edad;

    @Column private String nombre;

    public EspectadoresModels(Long idespectadores, int cantidad, String genero, int edad) {
        this.idespectadores = idespectadores;
        this.cantidad = cantidad;
        this.genero = genero;
        this.edad = edad;
    }



    public Long getIdespectadores() {
        return idespectadores;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdespectadores(Long idespectadores) {
        this.idespectadores = idespectadores;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
