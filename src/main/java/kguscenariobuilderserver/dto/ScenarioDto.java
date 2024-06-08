package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.dto.layer.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScenarioDTO {
    private Layer1DTO layer1DTO;
    private Layer2DTO layer2DTO;
    private Layer3DTO layer3DTO;
    private Layer4DTO layer4DTO;
    private Layer5DTO layer5DTO;
    private Layer6DTO layer6DTO;
    private Layer7DTO layer7DTO;

    public ScenarioDTO(Scenario scenario){
        this.layer1DTO = Layer1DTO.toDTO(scenario.getLayer1());
        this.layer2DTO = Layer2DTO.toDTO(scenario.getLayer2());
        this.layer3DTO = Layer3DTO.toDTO(scenario.getLayer3());
        this.layer4DTO = Layer4DTO.toDTO(scenario.getLayer4());
        this.layer5DTO = Layer5DTO.toDTO(scenario.getLayer5());
        this.layer6DTO = Layer6DTO.toDTO(scenario.getLayer6());
        this.layer7DTO = Layer7DTO.toDTO(scenario.getLayer7());
    };

}
