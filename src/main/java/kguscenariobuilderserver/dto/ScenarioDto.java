package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Scenario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ScenarioDto {
    private Layer1Dto layer1Dto;
    private Layer2Dto layer2Dto;
    private Layer3Dto layer3Dto;
    private Layer4Dto layer4Dto;
    private Layer5Dto layer5Dto;
    private Layer6Dto layer6Dto;
    private Layer7Dto layer7Dto;

    public ScenarioDto(Scenario scenario){
        this.layer1Dto = Layer1Dto.toDto(scenario.getLayer1());
        this.layer2Dto = Layer2Dto.toDto(scenario.getLayer2());
        this.layer3Dto = Layer3Dto.toDto(scenario.getLayer3());
        //this.layer4Dto = Layer4Dto.toDto(scenario.getLayer4());
        this.layer5Dto = Layer5Dto.toDto(scenario.getLayer5());
        this.layer6Dto = Layer6Dto.toDto(scenario.getLayer6());
        this.layer7Dto = Layer7Dto.toDto(scenario.getLayer7());

    };
}
