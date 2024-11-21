package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class AutonomousVehicle {
    private String av_type;
    private int av_lane_position;
    private String av_speed;
    private String av_action_start;
    private String av_action_perform;
}
