package com.example.mbg.Repository;

import com.example.mbg.Entity.DueñoProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDueñoProyectoRepository extends JpaRepository<DueñoProyecto, Long> {
    
}
