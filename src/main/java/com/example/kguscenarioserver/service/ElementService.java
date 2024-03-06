package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.entity.Element;
import com.example.kguscenarioserver.repository.ElementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;
    public Element getElement(Long id){
        return elementRepository.findById(id).get();
    }

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

    public void deleteElement(Element element){
        elementRepository.deleteById(element.getId());
    }


}
