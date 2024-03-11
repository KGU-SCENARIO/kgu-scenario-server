package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.element.ElementRequest;
import com.example.kguscenarioserver.dto.element.UpdateElementRequest;
import com.example.kguscenarioserver.entity.Element;
import com.example.kguscenarioserver.entity.Type;
import com.example.kguscenarioserver.service.ElementService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ElementController {

    private final ElementService elementService;

    //element 저장
    @PostMapping("/save_element")
    public void saveElement(@RequestBody @Valid ElementRequest request){
        elementService.saveElement(convertToElement(request));
    }

    //element-layer 여러개 한번에 저장
    @PostMapping("/save_elements")
    public void saveElementsLayer(@RequestBody @Valid List<ElementRequest> requests){
        for(ElementRequest request : requests){
            elementService.saveElement(convertToElement(request));
        }
    }
    //element 삭제
    @DeleteMapping("/delete_element/{id}")
    public void deleteElement(@PathVariable Long id){
        Element element = elementService.getElement(id);
        elementService.deleteElement(element);
    }

    //element 수정
    @PostMapping("/update_element")
    public void updateElement(@RequestBody @Valid UpdateElementRequest request,
                              HttpServletResponse response) throws IOException{
        elementService.updateElement(request.getId(), request.getUpdateName());
        response.sendRedirect("/scenario_list");
    }

    //dto -> entity 변환
    private Element convertToElement(ElementRequest request) {
        Element element = new Element();
        element.setId(request.getId());
        element.setType(request.getType());
        element.setName(request.getName());

        if(element.getType() != Type.LAYER){
            Long parentId = request.getParentId();
            element.setParent(elementService.getElement(parentId));
        }

        return element;
    }

}
