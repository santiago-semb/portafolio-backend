package com.example.mbg.Security.Entity;

import com.example.mbg.Security.Enums.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    //@Enumerated DEFINE LOS VALORES QUE VAMOS A INGRESAR (TIPO STRING)
    @Enumerated(EnumType.STRING)
    @Size(min=1,max=50, message="El nombre del rol debe tener entre 1 y 50 caracteres.")
    private RolNombre rolNombre;
    
    public Rol() { }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
}
