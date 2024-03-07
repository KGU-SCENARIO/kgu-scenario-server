package com.example.kguscenarioserver.dto.element;

import com.example.kguscenarioserver.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InitElementRequest {
    private Long id;
    private Type type;
    private String name;
    private Long parentId;
}
