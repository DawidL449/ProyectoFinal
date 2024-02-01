package com.trifulcas.Models;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class PeliculasModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculas_id")
    private int peliculasId;

    @Column(name = "peliculas", nullable = false)
    private String peliculas;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public PeliculasModels() {
        super();
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());

    }

    public PeliculasModels(String country) {
        this();
        this.peliculas = country;
    }

    public int getCountryId() {
        return peliculasId;
    }

    public void setCountryId(int countryId) {
        this.peliculasId = countryId;
    }

    public String getCountry() {
        return peliculas;
    }

    public void setCountry(String peliculas) {
        this.peliculas = peliculas;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Peliculas [peliculasId=" + peliculasId + ", country=" + peliculas + ", lastUpdate=" + lastUpdate + "]";
    }


    public void setName(String espectadoresRepository) {
    }

    public Object getName() {
        return null;
    }
}