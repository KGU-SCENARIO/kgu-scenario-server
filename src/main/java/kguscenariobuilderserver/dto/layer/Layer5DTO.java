package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer5;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer5DTO {
    @JsonProperty("시간대")
    private String 시간대;
    @JsonProperty("요일")
    private String 요일;
    @JsonProperty("날씨")
    private String 날씨;
    @JsonProperty("기온")
    private String 기온;
    @JsonProperty("조도")
    private String 조도;

    public static Layer5DTO toDTO(Layer5 layer5){
        return Layer5DTO.builder()
                .시간대(layer5.get시간대())
                .요일(layer5.get요일())
                .날씨(layer5.get날씨())
                .기온(layer5.get기온())
                .조도(layer5.get조도())
                .build();
    }
}
