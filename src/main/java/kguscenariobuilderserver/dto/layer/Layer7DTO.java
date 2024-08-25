package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer7;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Layer7DTO {
    @JsonProperty("법ㆍ규제")
    private String law_regulation;

    public static Layer7DTO toDTO(Layer7 layer7){
        return Layer7DTO.builder()
                .law_regulation(layer7.getLaw_regulation())
                .build();
    }
}
