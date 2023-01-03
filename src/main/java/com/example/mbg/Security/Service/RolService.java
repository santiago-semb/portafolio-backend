package com.example.mbg.Security.Service;

import com.example.mbg.Security.Entity.Rol;
import com.example.mbg.Security.Enums.RolNombre;
import com.example.mbg.Security.Repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired 
    IRolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
 
}
