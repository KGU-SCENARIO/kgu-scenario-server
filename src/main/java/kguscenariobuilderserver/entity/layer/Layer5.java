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
  
    @Column(nullable = false)
    private String time_zone;
    
    @Column(nullable = false)
    private String day_of_week;
  
    @Column(nullable = false)
    private String weather;
    
    @Column(nullable = false) 
    private String temperature;
    
    @Column(nullable = false)
    private String illumination;
}
