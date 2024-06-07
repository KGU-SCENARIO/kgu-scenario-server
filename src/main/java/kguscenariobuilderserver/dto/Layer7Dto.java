package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Layer7;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Layer7Dto {
    private String 법ㆍ규제;

    public static Layer7Dto toDto(Layer7 layer7){
        return new Layer7Dto(
                layer7.get법ㆍ규제()
        );
    }
}
