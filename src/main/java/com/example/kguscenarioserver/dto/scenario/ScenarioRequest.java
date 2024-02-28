package com.example.kguscenarioserver.dto.scenario;

import com.example.kguscenarioserver.entity.Scenario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScenarioRequest {
    private String memo;
    private String result;

}
