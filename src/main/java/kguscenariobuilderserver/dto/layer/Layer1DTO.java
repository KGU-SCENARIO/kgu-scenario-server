package kguscenariobuilderserver.dto.layer;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import kguscenariobuilderserver.entity.layer.Layer1;
import lombok.Builder;

@Builder
public record Layer1DTO(
        @NotBlank
        @JsonProperty("도로 기능과 등급")
        String road_function_and_Grade,

        @NotBlank
        @JsonProperty("차로폭")
        String lane_width,

        @NotBlank
        @JsonProperty("갓길폭")
        String shoulder_width,

        @NotBlank
        @JsonProperty("도로선형")
        String road_alignment,

        @NotBlank
        @JsonProperty("도로경사")
        String road_gradient,

        @NotBlank
        @JsonProperty("차로 수")
        String number_of_lanes,

        @NotBlank
        @JsonProperty("도로 포장")
        String road_surface,

        @NotBlank
        @JsonProperty("노면 상태")
        String pavement_condition,

        @NotBlank
        @JsonProperty("도로유형")
        String road_type
) {
    public static Layer1DTO from(Layer1 layer1){
        return Layer1DTO.builder()
                .road_function_and_Grade(layer1.getRoad_function_and_Grade())
                .lane_width(layer1.getLane_width())
                .shoulder_width(layer1.getShoulder_width())
                .road_alignment(layer1.getRoad_alignment())
                .road_gradient(layer1.getRoad_gradient())
                .number_of_lanes(layer1.getNumber_of_lanes())
                .road_surface(layer1.getRoad_surface())
                .pavement_condition(layer1.getPavement_condition())
                .road_type(layer1.getRoad_type())
                .build();
    }
}
