package com.example.kguscenarioserver.dto.scenario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScenarioListDto<T> {
    private T data;
}
