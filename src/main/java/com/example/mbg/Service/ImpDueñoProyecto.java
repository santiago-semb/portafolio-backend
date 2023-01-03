package com.example.mbg.Service;

import com.example.mbg.Entity.DueñoProyecto;
import com.example.mbg.Interface.IDueñoProyectoService;
import com.example.mbg.Repository.IDueñoProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpDueñoProyecto implements IDueñoProyectoService {

    @Autowired
    IDueñoProyectoRepository dueñoRepository;
    
    @Override
    public List<DueñoProyecto> getDueños() {
        List<DueñoProyecto> dueños = dueñoRepository.findAll();
        return dueños;
    }

    @Override
    public void crearDueño(DueñoProyecto dueñoProyecto) {
        dueñoRepository.save(dueñoProyecto);
    }

    @Override
    public void eliminarDueño(Long id) {
        dueñoRepository.deleteById(id);
    }

    @Override
    public DueñoProyecto getDueño(Long id) {
        DueñoProyecto dueño = dueñoRepository.findById(id).orElse(null);
        return dueño;
    }
    
}
