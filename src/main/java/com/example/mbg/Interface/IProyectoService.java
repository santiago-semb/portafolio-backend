package com.example.mbg.Interface;

import com.example.mbg.Entity.Proyecto;
import java.util.List;


public interface IProyectoService {
    
    public List<Proyecto> getProyectos();
    
    public void crearProyecto(Proyecto proyecto);
    
    public void eliminarProyecto(Long id);
    
    public Proyecto getProyecto(Long id);
    
}
