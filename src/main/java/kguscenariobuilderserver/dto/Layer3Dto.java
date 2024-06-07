package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Layer3;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Layer3Dto {
    private String 도로공사;
    private String 선행사고;
    private String 장애물;

    public static Layer3Dto toDto(Layer3 layer3){
        return new Layer3Dto(
                layer3.get도로공사(),
                layer3.get선행사고(),
                layer3.get장애물()
        );
    }
}
