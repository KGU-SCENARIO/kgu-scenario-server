package kguscenariobuilderserver.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Layer3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer3",fetch = FetchType.LAZY)
    private Scenario scenario;

    private String 도로공사;
    private String 선행사고;
    private String 장애물;
}
