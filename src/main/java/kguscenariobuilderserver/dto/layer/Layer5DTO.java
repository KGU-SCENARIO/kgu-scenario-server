package kguscenariobuilderserver.dto.layer;

import kguscenariobuilderserver.entity.layer.Layer5;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Layer5DTO {
    private String 시간대;
    private String 요일;
    private String 날씨;
    private String 기온;
    private String 조도;

    public static Layer5DTO toDTO(Layer5 layer5){
        return new Layer5DTO(
                layer5.get시간대(),
                layer5.get요일(),
                layer5.get날씨(),
                layer5.get기온(),
                layer5.get조도()
        );
    }
}
