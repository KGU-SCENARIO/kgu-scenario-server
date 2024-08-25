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

    @JsonProperty("Camera센서")
    private String camera_sensor;

    @JsonProperty("Radar센서")
    private String radar_sensor;

    @JsonProperty("LiDAR센서")
    private String lidar_sensor;

    @JsonProperty("V2I")
    private String v2i_communication;

    @JsonProperty("V2V")
    private String v2v_communication;

    @JsonProperty("V2P")
    private String v2p_communication;

    @JsonProperty("V2N")
    private String v2n_communication;

    @JsonProperty("V2C")
    private String v2c_communication;

    @JsonProperty("GPS정보")
    private String gps_information;

    @JsonProperty("전자지도정보")
    private String electronic_map_information;

    public static Layer6DTO toDTO(Layer6 layer6){
        return Layer6DTO.builder()
                .camera_sensor(layer6.getCamera_sensor())
                .radar_sensor(layer6.getRadar_sensor())
                .lidar_sensor(layer6.getLidar_sensor())
                .v2i_communication(layer6.getV2i_communication())
                .v2v_communication(layer6.getV2v_communication())
                .v2p_communication(layer6.getV2p_communication())
                .v2n_communication(layer6.getV2n_communication())
                .v2c_communication(layer6.getV2c_communication())
                .gps_information(layer6.getGps_information())
                .electronic_map_information(layer6.getElectronic_map_information())
                .build();
    }
}
