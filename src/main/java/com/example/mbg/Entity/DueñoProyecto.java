package com.example.mbg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class DueñoProyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=2,max=30,message="El nombre debe contener entre 2 y 30 caracteres.")
    private String nombre;
    
    @NotNull
    @Size(min=2,max=30,message="El apellido debe contener entre 2 y 30 caracteres.")
    private String apellido;
    
    @NotNull
    @Min(value=18,message="La edad debe ser mayor a 18.")
    @Max(value=65,message="La edad debe ser menor a 65")
    private int edad;
    
    @NotNull
    @Size(min=2,max=300,message="La experiencia debe contener entre 2 y 300 caracteres.")
    private String experiencia;
    
    @NotNull
    @Size(min=2,max=300,message="La educacion debe contener entre 2 y 300 caracteres.")
    private String educacion;
    
}
