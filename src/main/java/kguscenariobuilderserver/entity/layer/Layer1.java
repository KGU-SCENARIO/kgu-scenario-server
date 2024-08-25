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
    private String road_function_and_Grade;
    private String lane_width;
    private String shoulder_width;
    private String road_alignment;
    private String road_gradient;
    private String number_of_lanes;
    private String road_surface;
    private String pavement_condition;
    private String road_type;

}
