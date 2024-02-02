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
public class CiudadesModels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idciudad;
    @Column(name="nombre")
    private String nombre;
    @Column(name="ubicacion")
    private String ubicacion;

    public Long getIdciudad() {
        return idciudad;
    }

    public String getNombre() {
        return nombre;

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdciudad(Long idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public String toString() {
        return "CiudadesModels{" +
                "idciudad=" + idciudad +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}