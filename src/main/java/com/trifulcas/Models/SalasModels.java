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
@Table(name = "models")
public class SalasModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salas_id")
    private int SalasModelsId;

    @Column(name = "salas", nullable = false)
    private String salas;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public SalasModels() {
        super();
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());

    }

    public SalasModels(String salas) {
        this();
        this.salas = salas;
    }

    public int getCountryId() {
        return SalasModelsId;
    }

    public void setCountryId(int SalasModelsId) {
        this.SalasModelsId = SalasModelsId;
    }

    public String getCountry() {
        return salas;
    }

    public void setCountry(String country) {
        this.salas = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Salas [SalasId=" + SalasModelsId + ", country=" + salas + ", lastUpdate=" + lastUpdate + "]";
    }


}