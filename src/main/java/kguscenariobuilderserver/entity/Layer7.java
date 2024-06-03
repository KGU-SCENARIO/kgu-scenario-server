package kguscenariobuilderserver.entity;

import jakarta.persistence.*;

@Entity
public class Layer7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer7",fetch = FetchType.LAZY)
    private Scenario scenario;

    private String 법ㆍ규제;
}
