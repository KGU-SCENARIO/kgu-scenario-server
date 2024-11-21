package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Layer4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer4")
    @JoinColumn(nullable = false)
    private Scenario scenario;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name="npc1_type")),
            @AttributeOverride(name="position_lane", column=@Column(name="npc1_position_lane")),
            @AttributeOverride(name="relative_distance", column=@Column(name="npc1_relative_distance")),
            @AttributeOverride(name="speed", column=@Column(name="npc1_speed")),
            @AttributeOverride(name="acceleration", column=@Column(name="npc1_acceleration")),
            @AttributeOverride(name="trigger_acceleration", column=@Column(name="npc1_trigger_acceleration")),
            @AttributeOverride(name="action_start", column=@Column(name="npc1_action_start")),
            @AttributeOverride(name="action_perform", column=@Column(name="npc1_action_perform")),
            @AttributeOverride(name="trigger_action", column=@Column(name="npc1_trigger_action"))
    })
    @Column(nullable = false)
    private Npc npc1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name="npc2_type")),
            @AttributeOverride(name="position_lane", column=@Column(name="npc2_position_lane")),
            @AttributeOverride(name="relative_distance", column=@Column(name="npc2_relative_distance")),
            @AttributeOverride(name="speed", column=@Column(name="npc2_speed")),
            @AttributeOverride(name="acceleration", column=@Column(name="npc2_acceleration")),
            @AttributeOverride(name="trigger_acceleration", column=@Column(name="npc2_trigger_acceleration")),
            @AttributeOverride(name="action_start", column=@Column(name="npc2_action_start")),
            @AttributeOverride(name="action_perform", column=@Column(name="npc2_action_perform")),
            @AttributeOverride(name="trigger_action", column=@Column(name="npc2_trigger_action"))
    })
    @Column(nullable = false)
    private Npc npc2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name="npc3_type")),
            @AttributeOverride(name="position_lane", column=@Column(name="npc3_position_lane")),
            @AttributeOverride(name="relative_distance", column=@Column(name="npc3_relative_distance")),
            @AttributeOverride(name="speed", column=@Column(name="npc3_speed")),
            @AttributeOverride(name="acceleration", column=@Column(name="npc3_acceleration")),
            @AttributeOverride(name="trigger_acceleration", column=@Column(name="npc3_trigger_acceleration")),
            @AttributeOverride(name="action_start", column=@Column(name="npc3_action_start")),
            @AttributeOverride(name="action_perform", column=@Column(name="npc3_action_perform")),
            @AttributeOverride(name="trigger_action", column=@Column(name="npc3_trigger_action"))
    })
    @Column(nullable = false)
    private Npc npc3;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="type", column=@Column(name="npc4_type")),
            @AttributeOverride(name="position_lane", column=@Column(name="npc4_position_lane")),
            @AttributeOverride(name="relative_distance", column=@Column(name="npc4_relative_distance")),
            @AttributeOverride(name="speed", column=@Column(name="npc4_speed")),
            @AttributeOverride(name="acceleration", column=@Column(name="npc4_acceleration")),
            @AttributeOverride(name="trigger_acceleration", column=@Column(name="npc4_trigger_acceleration")),
            @AttributeOverride(name="action_start", column=@Column(name="npc4_action_start")),
            @AttributeOverride(name="action_perform", column=@Column(name="npc4_action_perform")),
            @AttributeOverride(name="trigger_action", column=@Column(name="npc4_trigger_action"))
    })
    @Column(nullable = false)
    private Npc npc4;

    @Column(nullable = false)
    private String traffic_condition_LOS;

    @Embedded
    @Column(nullable = false)
    private AutonomousVehicle autonomous_vehicle;

    public Layer4(){
        this.npc1 = new Npc();
        this.npc2 = new Npc();
        this.npc3 = new Npc();
        this.npc4 = new Npc();
        this.autonomous_vehicle= new AutonomousVehicle();
    }

}
