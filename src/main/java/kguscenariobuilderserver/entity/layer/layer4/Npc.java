package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Npc {
    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private int position_lane;

    @Column(nullable = false)
    private String relative_distance;

    @Column(nullable = false)
    private String speed;

    @Column(nullable = false)
    private String acceleration;

    @Column(nullable = false)
    private String trigger_acceleration;

    @Column(nullable = false)
    private String action_start;

    @Column(nullable = false)
    private String action_perform;

    @Column(nullable = false)
    private String trigger_action;
}
