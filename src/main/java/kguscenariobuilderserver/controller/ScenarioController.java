package kguscenariobuilderserver.controller;

import jakarta.validation.Valid;
import kguscenariobuilderserver.dto.ScenarioRequest;
import kguscenariobuilderserver.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import farmeasy.server.dto.response.Response;


@RestController
@RequiredArgsConstructor
@RequestMapping("/scenarios")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping
    public Response readScenarios(@RequestParam(required = false, defaultValue = "0",value = "page") int pageNo){
        return Response.success(scenarioService.readScenarioDTOs(pageNo));
    }

    @PostMapping
    public Response insertScenarios(@Valid @RequestBody ScenarioRequest scenarioRequest){
        return Response.success(scenarioService.saveScenarios(scenarioRequest));
    }


    @DeleteMapping
    public Response deleteScenarios(){
        return Response.success(scenarioService.deleteScenarios());
    }

}
