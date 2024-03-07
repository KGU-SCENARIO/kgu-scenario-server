package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.entity.Element;
import com.example.kguscenarioserver.repository.ElementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;

    //element 가져오는 메소드
    public Element getElement(Long id){
        return elementRepository.findById(id).get();
    }

    //저장 메소드
    @Transactional
    public void saveElement(Element saveElement){
        elementRepository.save(saveElement);
    }

    //삭제 메소드
    @Transactional
    public void deleteElement(Element element){
        elementRepository.deleteById(element.getId());
    }

    //수정 메소드
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
