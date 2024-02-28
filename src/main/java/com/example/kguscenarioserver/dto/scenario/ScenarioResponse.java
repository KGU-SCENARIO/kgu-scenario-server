package com.example.kguscenarioserver.dto.scenario;

import com.example.kguscenarioserver.entity.Scenario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ScenarioResponse<T> {
    private T data;
    private int count;
}
