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
    @OneToOne(mappedBy = "layer6",fetch = FetchType.LAZY)
    private Scenario scenario;

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
}
