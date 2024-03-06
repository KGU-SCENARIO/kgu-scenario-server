package com.example.kguscenarioserver.repository;

import com.example.kguscenarioserver.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {
    List<Element> findByNameAndParent(String name, Element parent);
    List<Element> deleteByNameAndParent(String name, Element parent);
}
