package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer3;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer3DTO {

    @JsonProperty("도로공사")
    private String road_construction;

    @JsonProperty("선행사고")
    private String previous_accident;

    @JsonProperty("장애물")
    private String obstacle;

    public static Layer3DTO toDTO(Layer3 layer3){
        return Layer3DTO.builder()
                .road_construction(layer3.getRoad_construction())
                .previous_accident(layer3.getPrevious_accident())
                .obstacle(layer3.getObstacle())
                .build();
    }
}
