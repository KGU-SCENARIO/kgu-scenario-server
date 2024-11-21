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

    @Column(nullable = false)
    private String camera_sensor;

    @Column(nullable = false)
    private String radar_sensor;

    @Column(nullable = false)
    private String lidar_sensor;

    @Column(nullable = false)
    private String v2i_communication;

    @Column(nullable = false)
    private String v2v_communication;

    @Column(nullable = false)
    private String v2p_communication;

    @Column(nullable = false)
    private String v2n_communication;

    @Column(nullable = false)
    private String v2c_communication;

    @Column(nullable = false)
    private String gps_information;

    @Column(nullable = false)
    private String electronic_map_information;
}
