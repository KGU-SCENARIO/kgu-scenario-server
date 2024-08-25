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
    private String time_zone;

    @JsonProperty("요일")
    private String day_of_week;

    @JsonProperty("날씨")
    private String weather;

    @JsonProperty("기온")
    private String temperature;

    @JsonProperty("조도")
    private String illumination;

    public static Layer5DTO toDTO(Layer5 layer5){
        return Layer5DTO.builder()
                .time_zone(layer5.getTime_zone())
                .day_of_week(layer5.getDay_of_week())
                .weather(layer5.getWeather())
                .temperature(layer5.getTemperature())
                .illumination(layer5.getIllumination())
                .build();
    }
}
