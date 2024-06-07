package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Layer6;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class Layer6Dto {
    private String Camera센서;
    private String Rader센서;
    private String LiDAR센서;
    private String V2I;
    private String V2V;
    private String V2P;
    private String V2N;
    private String V2C;
    private String GPS정보;
    private String 전자지도정보;

    public static Layer6Dto toDto(Layer6 layer6){
        return new Layer6Dto(
                layer6.getCamera센서(),
                layer6.getRader센서(),
                layer6.getLiDAR센서(),
                layer6.getV2I(),
                layer6.getV2V(),
                layer6.getV2P(),
                layer6.getV2N(),
                layer6.getV2C(),
                layer6.getGPS정보(),
                layer6.get전자지도정보()
        );
    }
}
