package kguscenariobuilderserver.dto.layer;


import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer1;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer1DTO {
    @JsonProperty("도로 기능과 등급")
    private String road_function_and_Grade;

    @JsonProperty("차로폭")
    private String lane_width;

    @JsonProperty("갓길폭")
    private String shoulder_width;

    @JsonProperty("도로선형")
    private String road_alignment;

    @JsonProperty("도로경사")
    private String road_gradient;

    @JsonProperty("차로 수")
    private String number_of_lanes;

    @JsonProperty("도로 포장")
    private String road_surface;

    @JsonProperty("노면 상태")
    private String pavement_condition;

    @JsonProperty("도로유형")
    private String road_type;

    public static Layer1DTO toDTO(Layer1 layer1){
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
