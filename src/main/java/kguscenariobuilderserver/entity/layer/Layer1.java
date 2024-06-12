package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer1",fetch = FetchType.LAZY)
    private Scenario scenario;
    private String 도로_기능과_등급;
    private String 차로폭;
    private String 갓길폭;
    private String 도로선형;
    private String 도로경사;
    private String 차로수;
    private String 도로포장;
    private String 노면상태;
    private String 도로유형;

}
