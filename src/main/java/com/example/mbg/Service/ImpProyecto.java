package com.example.mbg.Service;

import com.example.mbg.Entity.Proyecto;
import com.example.mbg.Interface.IProyectoService;
import com.example.mbg.Repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyecto implements IProyectoService {
    
    @Autowired
    IProyectoRepository proyectoRepository;

    @Override
    public List<Proyecto> getProyectos() {
        List<Proyecto> proyecto = proyectoRepository.findAll();
        return proyecto;
    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto getProyecto(Long id) {
        Proyecto proyecto = (Proyecto) proyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
    
}
