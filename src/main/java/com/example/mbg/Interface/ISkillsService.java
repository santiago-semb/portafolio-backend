package com.example.mbg.Interface;

import com.example.mbg.Entity.Skills;
import java.util.List;


public interface ISkillsService {
    
    public List<Skills> getSkills();
    
    public void crearSkill(Skills skill);
    
    public void eliminarSkill(Long id);
    
    public Skills getSkill(Long id);
    
}
