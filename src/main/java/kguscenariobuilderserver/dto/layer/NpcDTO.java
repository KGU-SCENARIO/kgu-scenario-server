package kguscenariobuilderserver.dto.layer;

import kguscenariobuilderserver.entity.layer.layer4.Npc;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class NpcDTO {
    private String 객체종류;
    private String 객체위치_차로;
    private String 객체위치_상대거리;
    private String 객체속도;
    private String 객체가감속도;
    private String Trigger_가감속;
    private String 객체행동_시작;
    private String 객체행동_동작;
    private String Trigger_동작;

    public Npc toEntity() {
        Npc npc = new Npc();
        npc.set객체종류(this.객체종류);
        npc.set객체위치_차로(this.객체위치_차로);
        npc.set객체위치_상대거리(this.객체위치_상대거리);
        npc.set객체속도(this.객체속도);
        npc.set객체가감속도(this.객체가감속도);
        npc.setTrigger_가감속(this.Trigger_가감속);
        npc.set객체행동_시작(this.객체행동_시작);
        npc.set객체행동_동작(this.객체행동_동작);
        npc.setTrigger_동작(this.Trigger_동작);
        return npc;
    }

}

