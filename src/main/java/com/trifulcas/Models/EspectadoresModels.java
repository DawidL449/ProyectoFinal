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
public class EspectadoresModels extends CiudadesModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "espectadores_id")
    private int espectadoresId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    // Como ya hemos especificado los datos de la tabla en film
    // Aquí nos basta con especificar la entidad en Film
    @ManyToMany(mappedBy="espectadores")
    // Anotación para evitar que al recuperar la categoría salgan las películas
    @JsonIgnore
    private Set<EspectadoresModels> films=new HashSet<>();

    public EspectadoresModels() {
        super();
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());

    }

    public EspectadoresModels(String name) {
        super();
        this.name = name;
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());
    }

    public int getEspectadoresId() {
        return espectadoresId;
    }

    public void setCiudadesId(int espectadoresId) {
        this.espectadoresId= espectadoresId;
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
        return "Espectadores [espectadoresId=" + espectadoresId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
    }

}