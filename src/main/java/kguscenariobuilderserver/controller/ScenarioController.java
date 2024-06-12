package kguscenariobuilderserver.controller;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import farmeasy.server.dto.response.Response;

import java.awt.print.Pageable;


@RestController
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping("/scenarios")
    public Response readScenarios(@RequestParam(required = false, defaultValue = "0",value = "page") int pageNo){
        return Response.success(scenarioService.readScenarioDTOs(pageNo));
    }

    @PostMapping("/scenarios")
    public Response insertScenarios(@RequestBody InsertScenario insertScenario){
        return Response.success(scenarioService.saveScenarios(insertScenario));
    }

}
