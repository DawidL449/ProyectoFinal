package com.trifulcas.Models;



import javax.persistence.*;

import lombok.*;

@Getter
@Table
@Data
    public class SalasModels{
        private Long id;
        private String Nombre;
        private String Descripcion;
        private String Genero;


    }
