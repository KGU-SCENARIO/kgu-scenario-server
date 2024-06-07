package kguscenariobuilderserver.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Layer4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer4",fetch = FetchType.LAZY)
    private Scenario scenario;
}
