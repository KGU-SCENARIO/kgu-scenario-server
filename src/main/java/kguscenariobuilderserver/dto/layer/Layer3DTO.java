package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import kguscenariobuilderserver.entity.layer.Layer3;
import lombok.Builder;

@Builder
public record Layer3DTO (
        @NotBlank
        @JsonProperty("도로공사")
        String road_construction,

        @NotBlank
        @JsonProperty("선행사고")
        String previous_accident,

        @NotBlank
        @JsonProperty("장애물")
        String obstacle
) {
    public static Layer3DTO from(Layer3 layer3){
        return Layer3DTO.builder()
                .road_construction(layer3.getRoad_construction())
                .previous_accident(layer3.getPrevious_accident())
                .obstacle(layer3.getObstacle())
                .build();
    }
}
