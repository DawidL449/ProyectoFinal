package com.trifulcas.Models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudades")
public class CiudadesModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciudades_id")
    private int ciudadesId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    // Como ya hemos especificado los datos de la tabla en film
    // Aquí nos basta con especificar la entidad en Film
    @ManyToMany(mappedBy="ciudades")
    // Anotación para evitar que al recuperar la categoría salgan las películas
    @JsonIgnore
    private Set<CiudadesModels> films=new HashSet<>();

    public CiudadesModels() {
        super();
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());

    }

    public CiudadesModels(String name) {
        super();
        this.name = name;
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());
    }

    public static EspectadoresModels save(CiudadesModels ciudadesModels) {
        return null;
    }

    public static void setCategoryId(int id) {
    }

    public static EspectadoresModels save(EspectadoresModels espectadoresModels) {
        return null;
    }

    public static ScopedValue<Object> findById(int id) {
        return null;
    }

    public int getCategoryId() {
        return ciudadesId;
    }

    public void setCiudadesId(int ciudadesId) {
        this.ciudadesId= ciudadesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Ciudades [ciudadesId=" + ciudadesId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
    }

}