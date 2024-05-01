package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.scenario.ScenarioDto;
import com.example.kguscenarioserver.dto.scenario.ScenarioListDto;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.service.ScenarioService;
import io.swagger.v3.oas.annotations.Operation;
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

    //시나리오 리스트 조회
    @GetMapping("/scenario_list")
    @Operation(summary = "scenario list 조회")
    public ScenarioListDto scenarioList(){
        List<Scenario> scenarios = scenarioService.scenarioList();
        List<ScenarioDto> collect = scenarios.stream()
                .map(m-> convertToScenarioDto(m))
                .collect(Collectors.toList());
        return new ScenarioListDto(collect);
    }

    //시나리오 저장
    @PostMapping("/save_scenario")
    @Operation(summary = "scenario 한가지 저장")
    public void saveScenario(@RequestBody @Valid ScenarioDto request,
                             HttpServletResponse response) throws IOException {
        scenarioService.saveScenario(convertToScenario(request));
        response.sendRedirect("/scenario_list");
    }

    //시나리오들을 한번에 저장
    @PostMapping("/save_scenarios")
    @Operation(summary = "scenario 여러개 저장")
    public void saveScenarios(@RequestBody @Valid List<ScenarioDto> request){
        List<Scenario> scenarios = request.stream()
                .map(m -> convertToScenario(m))
                .collect(Collectors.toList());

        scenarioService.saveScenarios(scenarios);
    }

    //시나리오를 삭제
    @DeleteMapping("/delete_scenario/{id}")
    @Operation(summary = "해당 scenario 삭제")
    public void deleteScenario(@PathVariable Long id,
                               HttpServletResponse response) throws IOException {
        try{
            scenarioService.deleteScenario(id);
            response.sendRedirect("/scenario_list");
        } catch (NoSuchElementException e){
            response.sendError(response.SC_NOT_FOUND,"해당 시나리오가 없습니다.");
        } catch (Exception e){
            response.sendError(response.SC_INTERNAL_SERVER_ERROR,"에러가 발생했습니다.");
        }
    }

    //모든 시나리오 삭제
    @DeleteMapping("/delete_all_scenario")
    @Operation(summary = "모든 scenario 삭제")
    public void deleteAllScenario(HttpServletResponse response) throws IOException {
        scenarioService.deleteAllScenario();
        response.sendRedirect("/scenario_list");
    }

    //dto -> entity 변환
    private Scenario convertToScenario(ScenarioDto dto) {
        Scenario scenario = new Scenario(dto.getMemo(), dto.getResult());
        return scenario;
    }

    //entity -> dto 변환
    private ScenarioDto convertToScenarioDto(Scenario scenario) {
        ScenarioDto scenarioDto = new ScenarioDto(scenario.getMemo(),scenario.getResult());
        return scenarioDto;
    }

}
