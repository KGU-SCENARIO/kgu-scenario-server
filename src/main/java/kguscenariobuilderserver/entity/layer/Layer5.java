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

    @OneToOne(mappedBy = "layer5")
    private Scenario scenario;
    private String time_zone;
    private String day_of_week;
    private String weather;
    private String temperature;
    private String illumination;
}
