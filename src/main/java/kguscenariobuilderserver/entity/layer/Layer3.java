package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "layer3")
    private Scenario scenario;

    @Column(nullable = false)
    private String road_construction;

    @Column(nullable = false)
    private String previous_accident;

    @Column(nullable = false)
    private String obstacle;
}
