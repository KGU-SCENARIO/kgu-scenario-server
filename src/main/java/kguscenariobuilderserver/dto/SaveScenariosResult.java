package kguscenariobuilderserver.dto;

public class SaveScenariosResult {
    private int layer1Size;
    private int layer2Size;
    private int layer3Size;
    private int layer4Size;
    private int layer5Size;
    private int layer6Size;
    private int layer7Size;

    public SaveScenariosResult(InsertScenario insertScenario){
        this.layer1Size = insertScenario.getLayer1DTOs().size();
        this.layer2Size = insertScenario.getLayer2DTOs().size();
        this.layer3Size = insertScenario.getLayer3DTOs().size();
        this.layer4Size = insertScenario.getLayer4DTOs().size();
        this.layer5Size = insertScenario.getLayer5DTOs().size();
        this.layer6Size = insertScenario.getLayer6DTOs().size();
        this.layer7Size = insertScenario.getLayer7DTOs().size();
    }

}
