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

    @OneToOne(mappedBy = "layer1")
    private Scenario scenario;

    @Column(nullable = false)
    private String road_function_and_Grade;

    @Column(nullable = false)
    private String lane_width;

    @Column(nullable = false)
    private String shoulder_width;

    @Column(nullable = false)
    private String road_alignment;

    @Column(nullable = false)
    private String road_gradient;

    @Column(nullable = false)
    private String number_of_lanes;

    @Column(nullable = false)
    private String road_surface;

    @Column(nullable = false)
    private String pavement_condition;

    @Column(nullable = false)
    private String road_type;

}
