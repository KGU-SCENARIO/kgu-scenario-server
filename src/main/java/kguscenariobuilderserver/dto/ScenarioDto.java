package kguscenariobuilderserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kguscenariobuilderserver.dto.layer.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Builder;


@Builder
public record ScenarioDTO(
    @NotNull
    Long id,

    @NotBlank
    Layer1DTO layer1DTO,

    @NotBlank
    Layer2DTO layer2DTO,

    @NotBlank
    Layer3DTO layer3DTO,

    @NotBlank
    Layer4DTO layer4DTO,

    @NotBlank
    Layer5DTO layer5DTO,

    @NotBlank
    Layer6DTO layer6DTO,

    @NotBlank
    Layer7DTO layer7DTO,

    @NotBlank
    String tc_description
) {
    public static ScenarioDTO from(Scenario scenario){
        return ScenarioDTO.builder()
            .id(scenario.getId())
            .layer1DTO(Layer1DTO.from(scenario.getLayer1()))
            .layer2DTO(Layer2DTO.from(scenario.getLayer2()))
            .layer3DTO(Layer3DTO.from(scenario.getLayer3()))
            .layer4DTO(Layer4DTO.from(scenario.getLayer4()))
            .layer5DTO(Layer5DTO.from(scenario.getLayer5()))
            .layer6DTO(Layer6DTO.from(scenario.getLayer6()))
            .layer7DTO(Layer7DTO.from(scenario.getLayer7()))
            .tc_description(scenario.getTc_description())
            .build();
    }
}
