package com.trifulcas.Models;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Entity
@Table
@Data
public class CinesModels {
        private Long id;
        private String Nombre;
        private String Capital;

    public static CinesModels save(CinesModels cinesModels) {
        return cinesModels;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return Nombre;
        }

        public String getCapital() {
            return Capital;
        }

        public void setCapital(String capital) {
            Capital = capital;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

    public String getName() {
            return null;
    }
}


