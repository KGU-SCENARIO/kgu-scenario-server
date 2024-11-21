package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import kguscenariobuilderserver.entity.layer.Layer5;
import lombok.Builder;

@Builder
public record Layer5DTO(
    @NotBlank
    @JsonProperty("시간대")
    String time_zone,

    @NotBlank
    @JsonProperty("요일")
    String day_of_week,

    @NotBlank
    @JsonProperty("날씨")
    String weather,

    @NotBlank
    @JsonProperty("기온")
    String temperature,

    @NotBlank
    @JsonProperty("조도")
    String illumination
) {
    public static Layer5DTO from(Layer5 layer5){
        return Layer5DTO.builder()
                .time_zone(layer5.getTime_zone())
                .day_of_week(layer5.getDay_of_week())
                .weather(layer5.getWeather())
                .temperature(layer5.getTemperature())
                .illumination(layer5.getIllumination())
                .build();
    }
}
