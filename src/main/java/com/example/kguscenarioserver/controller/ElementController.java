package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.element.ElementRequest;
import com.example.kguscenarioserver.dto.element.UpdateElementRequest;
import com.example.kguscenarioserver.entity.Element;
import com.example.kguscenarioserver.entity.Type;
import com.example.kguscenarioserver.service.ElementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElementController {

    private final ElementService elementService;

    //element 저장
    @PostMapping("/save_element")
    @Operation(summary = "element 저장")
    public void saveElement(@Parameter(required = true)@RequestBody @Valid ElementRequest request){
        elementService.saveElement(convertToElement(request));
    }

    //element-layer 여러개 한번에 저장
    @PostMapping("/save_elements")
    @Operation(summary = "element를 여러개 저장")
    public void saveElementsLayer(@Parameter(required = true)@RequestBody @Valid List<ElementRequest> requests){
        for(ElementRequest request : requests){
            elementService.saveElement(convertToElement(request));
        }
    }
    //element 삭제
    @DeleteMapping("/delete_element/{id}")
    @Operation(summary = "element를 삭제")
    public void deleteElement(@Parameter(required = true)@PathVariable Long id){
        Element element = elementService.getElement(id);
        elementService.deleteElement(element);
    }

    //element 수정
    @PostMapping("/update_element")
    @Operation(summary = "element 내용을 수정")
    public void updateElement(@RequestBody @Valid UpdateElementRequest request,
                              HttpServletResponse response) throws IOException{
        elementService.updateElement(request.getId(), request.getUpdateName());
        response.sendRedirect("/scenario_list");
    }

    //dto -> entity 변환
    private Element convertToElement(ElementRequest request) {
        Element element = new Element(request);
        
        if(element.getType() != Type.LAYER){
            Long parentId = request.getParentId();
            element.setParent(elementService.getElement(parentId));
        }
        return element;
    }

}
