package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Npc {
    private String 객체종류;
    private String 객체위치_차로;
    private String 객체위치_상대거리;
    private String 객체속도;
    private String 객체가감속도;
    private String Trigger_가감속;
    private String 객체행동_시작;
    private String 객체행동_동작;
    private String Trigger_동작;

}
