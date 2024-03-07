package com.example.kguscenarioserver.dto.element;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateElementRequest {
    private Long id;
    private String updateName;
}
