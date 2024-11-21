package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "layer7")
    private Scenario scenario;

    @Column(nullable = false)
    private String law_regulation;
}
