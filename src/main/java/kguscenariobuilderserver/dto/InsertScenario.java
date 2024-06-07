package kguscenariobuilderserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsertScenario {
    private List<Layer1Dto> layer1Dtos;
    private List<Layer2Dto> layer2Dtos;
    private List<Layer3Dto> layer3Dtos;
    private List<Layer4Dto> layer4Dtos;
    private List<Layer5Dto> layer5Dtos;
    private List<Layer6Dto> layer6Dtos;
    private List<Layer7Dto> layer7Dtos;
}
