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
    private String 도로_기능과_등급;

    private String 차로폭;

    private String 갓길폭;

    private String 도로선형;

    private String 도로경사;

    @JsonProperty("차로 수")
    private String 차로수;

    @JsonProperty("도로 포장")
    private String 도로포장;

    @JsonProperty("노면 상태")
    private String 노면상태;

    private String 도로유형;

    public static Layer1DTO toDTO(Layer1 layer1){
        return Layer1DTO.builder()
                .도로_기능과_등급(layer1.get도로_기능과_등급())
                .차로폭(layer1.get차로폭())
                .갓길폭(layer1.get갓길폭())
                .도로선형(layer1.get도로선형())
                .도로경사(layer1.get도로경사())
                .차로수(layer1.get차로수())
                .도로포장(layer1.get도로포장())
                .노면상태(layer1.get노면상태())
                .도로유형(layer1.get도로유형())
                .build();
    }
}
