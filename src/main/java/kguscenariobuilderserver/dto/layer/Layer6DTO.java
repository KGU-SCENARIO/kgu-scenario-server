package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer6;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer6DTO {
    private String Camera센서;
    private String Radar센서;
    private String LiDAR센서;
    private String V2I;
    private String V2V;
    private String V2P;
    private String V2N;
    private String V2C;
    private String GPS정보;
    @JsonProperty("전자지도정보")
    private String 전자지도정보;

    public static Layer6DTO toDTO(Layer6 layer6){
        return Layer6DTO.builder()
                .Camera센서(layer6.getCamera센서())
                .Radar센서(layer6.getRadar센서())
                .LiDAR센서(layer6.getLiDAR센서())
                .V2I(layer6.getV2I())
                .V2V(layer6.getV2V())
                .V2P(layer6.getV2P())
                .V2N(layer6.getV2N())
                .V2C(layer6.getV2C())
                .GPS정보(layer6.getGPS정보())
                .전자지도정보(layer6.get전자지도정보())
                .build();
    }
}
