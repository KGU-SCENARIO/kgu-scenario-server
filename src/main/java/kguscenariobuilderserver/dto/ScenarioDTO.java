package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.dto.layer.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Builder;


@Builder
public record ScenarioDTO(

    Long id,

    Layer1DTO layer1DTO,

    Layer2DTO layer2DTO,

    Layer3DTO layer3DTO,

    Layer4DTO layer4DTO,

    Layer5DTO layer5DTO,

    Layer6DTO layer6DTO,

    Layer7DTO layer7DTO,

    String tc_description
) {
    public ScenarioDTO(Scenario scenario) {
        this(
            scenario.getId(),
            Layer1DTO.from(scenario.getLayer1()),
            Layer2DTO.from(scenario.getLayer2()),
            Layer3DTO.from(scenario.getLayer3()),
            Layer4DTO.from(scenario.getLayer4()),
            Layer5DTO.from(scenario.getLayer5()),
            Layer6DTO.from(scenario.getLayer6()),
            Layer7DTO.from(scenario.getLayer7()),
            scenario.getTc_description()
        );
    }
}
