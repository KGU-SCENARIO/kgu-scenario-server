package com.example.kguscenarioserver.dto.scenario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScenarioListResponse<T> {
    private T data;
    private int count;
}
