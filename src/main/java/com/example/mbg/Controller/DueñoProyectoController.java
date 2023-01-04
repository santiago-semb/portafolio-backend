package com.example.mbg.Controller;

import com.example.mbg.Entity.DueñoProyecto;
import com.example.mbg.Interface.IDueñoProyectoService;
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
public class DueñoProyectoController {
    
    @Autowired
    IDueñoProyectoService dueñoService;
    
    @GetMapping("/dueño/traer")
    public List<DueñoProyecto> getDueños(){
        List<DueñoProyecto> dueños = dueñoService.getDueños();
        return dueños;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/dueño/crear")
    public String crearDueño(@RequestBody DueñoProyecto dueño){
        dueñoService.crearDueño(dueño);
        return "Se ha creado el dueño correctamente.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/dueño/eliminar/{id}")
    public String eliminarDueño(@PathVariable Long id){
        dueñoService.eliminarDueño(id);
        return "Se ha eliminado el dueño correctamente.";
    }
    
    @GetMapping("/dueño/traer/{id}")
    public DueñoProyecto getDueño(@PathVariable Long id){
        DueñoProyecto dueño = dueñoService.getDueño(id);
        return dueño;
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/dueño/actualizar/{id}")
    public DueñoProyecto actualizarDueño(@PathVariable Long id,
                                         @RequestParam("nombre") String nombre,
                                         @RequestParam("apellido") String apellido,
                                         @RequestParam("edad") int edad,
                                         @RequestParam("experiencia") String experiencia,
                                         @RequestParam("educacion") String educacion){
        DueñoProyecto dueñoActualizar = dueñoService.getDueño(id);
        dueñoActualizar.setNombre(nombre);
        dueñoActualizar.setApellido(apellido);
        dueñoActualizar.setEdad(edad);
        dueñoActualizar.setExperiencia(experiencia);
        dueñoActualizar.setEducacion(educacion);
        
        dueñoService.crearDueño(dueñoActualizar);
        return dueñoActualizar;
    }
    
}
