package kguscenariobuilderserver.dto.layer;

import kguscenariobuilderserver.entity.layer.Layer3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Layer3DTO {
    private String 도로공사;
    private String 선행사고;
    private String 장애물;

    public static Layer3DTO toDTO(Layer3 layer3){
        return new Layer3DTO(
                layer3.get도로공사(),
                layer3.get선행사고(),
                layer3.get장애물()
        );
    }
}
