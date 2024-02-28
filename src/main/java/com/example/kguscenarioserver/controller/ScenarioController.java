package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.scenario.ScenarioList;
import com.example.kguscenarioserver.dto.scenario.ScenarioRequest;
import com.example.kguscenarioserver.dto.scenario.ScenarioListResponse;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.service.ScenarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;
    @GetMapping("/scenario_list")
    public ScenarioListResponse scenarioList(){
        List<Scenario> scenarios = scenarioService.scenarioList();
        List<ScenarioList> collect = scenarios.stream()
                .map(m-> new ScenarioList(m.getMemo(), m.getResult()))
                .collect(Collectors.toList());
        return new ScenarioListResponse(collect,collect.size());
    }

    @PostMapping("/scenario_save")
    public String scenarioSave(@RequestBody @Valid
                                         ScenarioRequest request){
        Scenario scenario = new Scenario();
        scenario.setMemo(request.getMemo());
        scenario.setResult(request.getResult());
        scenarioService.saveScenario(scenario);

        return "redirect:/scenario_list";
    }
}
