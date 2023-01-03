package com.example.mbg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Table(name="proyectos")
@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=2,max=50,message="El nombre del proyecto debe tener entre 2 y 50 caracteres.")
    private String nombre;
    
    @NotNull
    @Size(min=2,max=50,message="El lenguaje del proyecto debe tener entre 2 y 50 caracteres.")
    private String lenguaje;
    
    @NotNull
    private String link;
    
}
