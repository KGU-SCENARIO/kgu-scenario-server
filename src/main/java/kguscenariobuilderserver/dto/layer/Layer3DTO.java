package kguscenariobuilderserver.dto.layer;

import kguscenariobuilderserver.entity.layer.Layer3;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer3DTO {

    private String 도로공사;

    private String 선행사고;

    private String 장애물;

    public static Layer3DTO toDTO(Layer3 layer3){
        return Layer3DTO.builder()
                .도로공사(layer3.get도로공사())
                .선행사고(layer3.get선행사고())
                .장애물(layer3.get장애물())
                .build();
    }
}
