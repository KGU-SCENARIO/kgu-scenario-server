package kguscenariobuilderserver.controller;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import farmeasy.server.dto.response.Response;


@RestController
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping("/scenarios")
    public Response readScenarios(){
        return Response.success(scenarioService.readScenarioDTOs());
    }

    @PostMapping("/scenarios")
    public Response insertScenarios(@RequestBody InsertScenario insertScenario){
        return Response.success(scenarioService.saveScenarios(insertScenario));
    }

}
