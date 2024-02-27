package com.example.kguscenarioserver.repository;

import com.example.kguscenarioserver.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario,Long> {
}
