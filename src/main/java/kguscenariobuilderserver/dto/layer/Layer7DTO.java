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
    @JsonProperty("-")
    private String 법ㆍ규제;

    public static Layer7DTO toDTO(Layer7 layer7){
        return Layer7DTO.builder()
                .법ㆍ규제(layer7.get법ㆍ규제())
                .build();
    }
}
