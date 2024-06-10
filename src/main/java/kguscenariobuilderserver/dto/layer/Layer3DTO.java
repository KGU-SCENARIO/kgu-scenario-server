package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Layer3DTO {
    @JsonProperty("도로공사")
    private String 도로공사;
    @JsonProperty("선행사고")
    private String 선행사고;
    @JsonProperty("장애물")
    private String 장애물;

    public static Layer3DTO toDTO(Layer3 layer3){
        return new Layer3DTO(
                layer3.get도로공사(),
                layer3.get선행사고(),
                layer3.get장애물()
        );
    }
}
