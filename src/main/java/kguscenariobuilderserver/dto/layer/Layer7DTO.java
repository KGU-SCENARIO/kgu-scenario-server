package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import kguscenariobuilderserver.entity.layer.Layer7;
import lombok.*;

@Builder
public record Layer7DTO(
    @NotBlank
    @JsonProperty("법ㆍ규제")
    String law_regulation
) {
    public static Layer7DTO from(Layer7 layer7){
        return Layer7DTO.builder()
                .law_regulation(layer7.getLaw_regulation())
                .build();
    }
}
