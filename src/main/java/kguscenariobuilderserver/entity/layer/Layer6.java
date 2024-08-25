package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer6")
    private Scenario scenario;
    private String camera_sensor;
    private String radar_sensor;
    private String lidar_sensor;
    private String v2i_communication;
    private String v2v_communication;
    private String v2p_communication;
    private String v2n_communication;
    private String v2c_communication;
    private String gps_information;
    private String electronic_map_information;
}
