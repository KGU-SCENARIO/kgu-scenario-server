package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer7;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Layer7DTO {
    @JsonProperty("-")
    private String 법ㆍ규제;

    public static Layer7DTO toDTO(Layer7 layer7){
        return new Layer7DTO(
                layer7.get법ㆍ규제()
        );
    }
}
