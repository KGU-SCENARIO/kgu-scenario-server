package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer5 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer5",fetch = FetchType.LAZY)
    private Scenario scenario;

    private String 시간대;
    private String 요일;
    private String 날씨;
    private String 기온;
    private String 조도;
}
