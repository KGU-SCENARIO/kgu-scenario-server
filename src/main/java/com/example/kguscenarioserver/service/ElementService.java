package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.entity.Element;
import com.example.kguscenarioserver.repository.ElementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;
    public Element getElement(Long id){
        return elementRepository.findById(id).get();
    }

    @Transactional
    public void saveElement(Element saveElement){
        validateElement(saveElement);
        elementRepository.save(saveElement);
    }

    public void validateElement(Element element){
        List<Element> findElements = elementRepository.findByNameAndParent(element.getName(),element.getParent());
        if (!findElements.isEmpty()){
            throw new IllegalStateException("이미 존재하는 요소입니다.");
        }
    }

    @Transactional
    public void deleteElement(Element element){
        elementRepository.deleteById(element.getId());
    }

    @Transactional
    public void updateElement(Long id,String updateName){
        Optional<Element> updateElement = elementRepository.findById(id);
        if (updateElement.isPresent()) {
            Element update = updateElement.get();
            update.setName(updateName);
            elementRepository.save(update);
        } else {
            throw new EntityNotFoundException("Entity with id " + id + " not found");
        }
    }
}
