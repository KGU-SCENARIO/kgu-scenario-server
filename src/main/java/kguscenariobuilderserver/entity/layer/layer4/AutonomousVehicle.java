package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Column;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AutonomousVehicle {
    @Column(nullable = false)
    private String av_type;

    @Column(nullable = false)
    private int av_lane_position;

    @Column(nullable = false)
    private String av_speed;

    @Column(nullable = false)
    private String av_action_start;

    @Column(nullable = false)
    private String av_action_perform;
}
