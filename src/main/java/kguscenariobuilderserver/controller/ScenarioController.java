package kguscenariobuilderserver.controller;

import jakarta.validation.Valid;
import kguscenariobuilderserver.dto.ScenarioRequest;
import kguscenariobuilderserver.dto.response.Response;
import kguscenariobuilderserver.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;


@RestController
@RequiredArgsConstructor
@RequestMapping("/scenarios")
public class ScenarioController {

    private final ScenarioService scenarioService;

    @GetMapping
    public ResponseEntity<Response> readScenarios(@RequestParam(required = false, defaultValue = "0",value = "page") int pageNo){
        return ResponseEntity.ok(Response.success(scenarioService.readScenarioDTOs(pageNo), 200));
    }

    @PostMapping
    public ResponseEntity<Response> insertScenarios(@Valid @RequestBody ScenarioRequest scenarioRequest){
        return ResponseEntity.status(CREATED).body(Response.success(scenarioService.saveScenarios(scenarioRequest), 201));
    }


    @DeleteMapping
    public ResponseEntity<Response> deleteScenarios(){
        scenarioService.deleteScenarios();
        return ResponseEntity.status(NO_CONTENT).body(Response.success(null, 204));
    }

}
