package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Layer1;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Layer1Dto {
    private String 도로_기능과_등급;
    private String 차로폭;
    private String 갓길폭;
    private String 도로선형;
    private String 도로경사;
    private String 차로수;
    private String 도로포장;
    private String 노면상태;
    private String 도로유형;

    public static Layer1Dto toDto(Layer1 layer1){
        return new Layer1Dto(
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
