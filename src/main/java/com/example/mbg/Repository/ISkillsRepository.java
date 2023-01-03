package com.example.mbg.Repository;

import com.example.mbg.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long> {
    
}
