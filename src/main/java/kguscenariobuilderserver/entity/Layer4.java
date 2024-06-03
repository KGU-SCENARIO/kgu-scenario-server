package kguscenariobuilderserver.entity;

import jakarta.persistence.*;

@Entity
public class Layer4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer4",fetch = FetchType.LAZY)
    private Scenario scenario;
}
