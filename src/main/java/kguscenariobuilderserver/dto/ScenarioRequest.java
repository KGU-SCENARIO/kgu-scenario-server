package kguscenariobuilderserver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import kguscenariobuilderserver.dto.layer.*;
import lombok.Builder;

import java.util.List;

@Builder
public record ScenarioRequest (
    @NotEmpty
    List<Layer1DTO> layer1DTOs,

    @NotEmpty
    List<Layer2DTO> layer2DTOs,

    @NotEmpty
    List<Layer3DTO> layer3DTOs,

    @NotEmpty
    List<Layer4DTO> layer4DTOs,

    @NotEmpty
    List<Layer5DTO> layer5DTOs,

    @NotEmpty
    List<Layer6DTO> layer6DTOs,

    @NotEmpty
    List<Layer7DTO> layer7DTOs,

    @NotBlank
    String tc_description
){}
