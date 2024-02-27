package com.example.kguscenarioserver.repository;

import com.example.kguscenarioserver.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element,Long> {
}
