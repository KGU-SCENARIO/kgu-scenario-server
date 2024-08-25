package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Npc {
    private String type;
    private int position_lane;
    private String relative_distance;
    private String speed;
    private String acceleration;
    private String trigger_acceleration;
    private String action_start;
    private String action_perform;
    private String trigger_action;

}
