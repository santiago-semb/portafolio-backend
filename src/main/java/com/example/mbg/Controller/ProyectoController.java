package com.example.mbg.Controller;

import com.example.mbg.Entity.Proyecto;
import com.example.mbg.Interface.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portafolio-74db6.web.app")
public class ProyectoController {
    
    @Autowired
    IProyectoService proyectoService;
    
    @GetMapping("/proyectos/traer")
    public List<Proyecto> getProyectos(){
        List<Proyecto> proyectos = proyectoService.getProyectos();
        return proyectos;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/proyectos/crear")
    public String crearProyecto(@RequestBody Proyecto proyecto){
        proyectoService.crearProyecto(proyecto);
        return "Se ha creado el proyecto correctamente.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/proyectos/eliminar/{id}")
    public String eliminarProyecto(@PathVariable Long id){
        proyectoService.eliminarProyecto(id);
        return "Se ha eliminado el proyecto correctamente.";
    }
    
    @GetMapping("/proyectos/traer/{id}")
    public Proyecto getProyecto(@PathVariable Long id){
        Proyecto proyecto = proyectoService.getProyecto(id);
        return proyecto;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/proyectos/actualizar/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id,
                                       @RequestParam("nombre") String nombre,
                                       @RequestParam("lenguaje") String lenguaje,
                                       @RequestParam("link") String link){
        Proyecto proyectoActualizar = proyectoService.getProyecto(id);
        
        proyectoActualizar.setNombre(nombre);
        proyectoActualizar.setLenguaje(lenguaje);
        proyectoActualizar.setLink(link);
        
        proyectoService.crearProyecto(proyectoActualizar);
        return proyectoActualizar;
    }
    
}
