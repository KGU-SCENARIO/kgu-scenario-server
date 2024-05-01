package com.example.kguscenarioserver.controller;

import com.example.kguscenarioserver.dto.scenario.RequestScenario;
import com.example.kguscenarioserver.dto.scenario.ResponseScenario;
import com.example.kguscenarioserver.dto.scenario.ScenarioListDto;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.service.ScenarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.kguscenarioserver.dto.scenario.RequestScenario.convertToScenario;
import static com.example.kguscenarioserver.entity.Scenario.convertToScenarioDto;

@RestController
@RequiredArgsConstructor
public class ScenarioController {
    private final ScenarioService scenarioService;

    //시나리오 리스트 조회
    @GetMapping("/scenario_list")
    @Operation(summary = "scenario list 조회")
    public ScenarioListDto scenarioList(@Parameter(hidden = true) @PageableDefault(page = 1) Pageable pageable){
        Page<ResponseScenario> responseScenarioPage = scenarioService.scenarioList(pageable);
        return new ScenarioListDto(responseScenarioPage);
    }

    //시나리오 저장
    @PostMapping("/save_scenario")
    @Operation(summary = "scenario 한가지 저장")
    public void saveScenario(@RequestBody @Valid RequestScenario request,
                             HttpServletResponse response) throws IOException {
        scenarioService.saveScenario(convertToScenario(request));
        response.sendRedirect("/scenario_list");
    }

    //시나리오들을 한번에 저장
    @PostMapping("/save_scenarios")
    @Operation(summary = "scenario 여러개 저장")
    public void saveScenarioList(@RequestBody @Valid List<RequestScenario> request){
        List<Scenario> scenarioList = request.stream()
                .map(m -> convertToScenario(m))
                .collect(Collectors.toList());

        scenarioService.saveScenarioList(scenarioList);
    }

    //시나리오를 삭제
    @DeleteMapping("/delete_scenario/{id}")
    @Operation(summary = "해당 scenario 삭제")
    public void deleteScenario(@Parameter(required = true)@PathVariable Long id,
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

}
