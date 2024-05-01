package com.example.kguscenarioserver.dto.scenario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseScenario {
    private String result;
    private Timestamp createdAt;

}
