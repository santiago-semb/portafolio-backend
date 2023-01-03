package com.example.mbg.Controller;

import com.example.mbg.Entity.Skills;
import com.example.mbg.Interface.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    
    @Autowired
    ISkillsService skillsService;
    
    @GetMapping("/skills/traer")
    public List<Skills> getSkills(){
        List<Skills> skills = skillsService.getSkills();
        return skills;
    }
    
    @PostMapping("/skills/crear")
    public String crearSkill(@RequestBody Skills skill){
        skillsService.crearSkill(skill);
        return "Se ha creado la skill correctamente.";
    }
    
    @DeleteMapping("/skills/eliminar/{id}")
    public String eliminarSkill(@PathVariable Long id){
        skillsService.eliminarSkill(id);
        return "Se ha eliminado la skill correctamente.";
    }
    
    @GetMapping("/skills/traer/{id}")
    public Skills getSkill(@PathVariable Long id){
        Skills skill = skillsService.getSkill(id);
        return skill;
    }
    
    @PutMapping("/skills/actualizar/{id}")
    public Skills actualizarSkill(@PathVariable Long id,
                                  @RequestParam("nombre") String nombre,
                                  @RequestParam("img") String img){
        Skills skillActualizar = skillsService.getSkill(id);
        
        skillActualizar.setNombre(nombre);
        skillActualizar.setImg(img);
        
        skillsService.crearSkill(skillActualizar);
        return skillActualizar;
    }
    
}
