package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.scenario.ScenarioDto;
import com.example.kguscenarioserver.dto.scenario.ScenarioListResponse;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.service.ScenarioService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ScenarioController {
    private final ScenarioService scenarioService;
    @GetMapping("/scenario_list")
    public ScenarioListResponse scenarioList(){
        List<Scenario> scenarios = scenarioService.scenarioList();
        List<ScenarioDto> collect = scenarios.stream()
                .map(m-> new ScenarioDto(m.getMemo(), m.getResult()))
                .collect(Collectors.toList());
        return new ScenarioListResponse(collect,collect.size());
    }

    @PostMapping("/save_scenario")
    public void saveScenario(@RequestBody @Valid ScenarioDto request,
                             HttpServletResponse response) throws IOException {
        Scenario scenario = new Scenario();
        scenario.setMemo(request.getMemo());
        scenario.setResult(request.getResult());
        scenarioService.saveScenario(scenario);

        response.sendRedirect("/scenario_list");
    }

    @DeleteMapping("/delete_scenario/{result}")
    public void deleteScenario(@PathVariable String result,
                               HttpServletResponse response) throws IOException {
        try{
            scenarioService.deleteScenario(result);
            response.sendRedirect("/scenario_list");
        } catch (NoSuchElementException e){
            response.sendError(response.SC_NOT_FOUND,"해당 시나리오가 없습니다.");
        } catch (Exception e){
            response.sendError(response.SC_INTERNAL_SERVER_ERROR,"에러가 발생했습니다.");
        }
    }

    @DeleteMapping("/delete_all_scenario")
    public void deleteAllScenario(HttpServletResponse response) throws IOException {
        scenarioService.deleteAllScenario();
        response.sendRedirect("/scenario_list");
    }

}
