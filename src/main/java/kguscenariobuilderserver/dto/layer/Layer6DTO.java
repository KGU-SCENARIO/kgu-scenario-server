package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

import kguscenariobuilderserver.entity.layer.Layer6;
import lombok.Builder;

@Builder
public record Layer6DTO(
    @NotBlank
    @JsonProperty("Camera센서")
    String camera_sensor,

    @NotBlank
    @JsonProperty("Radar센서")
    String radar_sensor,

    @NotBlank
    @JsonProperty("LiDAR센서")
    String lidar_sensor,

    @NotBlank
    @JsonProperty("V2I")
    String v2i_communication,

    @NotBlank
    @JsonProperty("V2V")
    String v2v_communication,

    @NotBlank
    @JsonProperty("V2P")
    String v2p_communication,

    @NotBlank
    @JsonProperty("V2N")
    String v2n_communication,

    @NotBlank
    @JsonProperty("V2C")
    String v2c_communication,

    @NotBlank
    @JsonProperty("GPS정보")
    String gps_information,

    @NotBlank
    @JsonProperty("전자지도정보")
    String electronic_map_information
) {
    public static Layer6DTO from(Layer6 layer6){
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
