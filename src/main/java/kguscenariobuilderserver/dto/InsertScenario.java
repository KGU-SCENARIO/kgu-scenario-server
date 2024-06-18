package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.dto.layer.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsertScenario {
    private List<Layer1DTO> layer1DTOs;
    private List<Layer2DTO> layer2DTOs;
    private List<Layer3DTO> layer3DTOs;
    private List<Layer4DTO> layer4DTOs;
    private List<Layer5DTO> layer5DTOs;
    private List<Layer6DTO> layer6DTOs;
    private List<Layer7DTO> layer7DTOs;
    private String tc_description;
}
