package kguscenariobuilderserver.dto.layer;


import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Layer1DTO {
    @JsonProperty("도로_기능과_등급")
    private String 도로_기능과_등급;

    @JsonProperty("차로폭")
    private String 차로폭;

    @JsonProperty("갓길폭")
    private String 갓길폭;

    @JsonProperty("도로선형")
    private String 도로선형;

    @JsonProperty("도로경사")
    private String 도로경사;

    @JsonProperty("차로수")
    private String 차로수;

    @JsonProperty("도로포장")
    private String 도로포장;

    @JsonProperty("노면상태")
    private String 노면상태;

    @JsonProperty("도로유형")
    private String 도로유형;

    public static Layer1DTO toDTO(Layer1 layer1){
        return new Layer1DTO(
                layer1.get도로_기능과_등급(),
                layer1.get차로폭(),
                layer1.get갓길폭(),
                layer1.get도로선형(),
                layer1.get도로경사(),
                layer1.get차로수(),
                layer1.get도로포장(),
                layer1.get노면상태(),
                layer1.get도로유형()
        );
    }
}
