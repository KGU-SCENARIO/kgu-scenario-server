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
    private Scenario scenario;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="객체종류", column=@Column(name="NPC1_객체종류")),
            @AttributeOverride(name="객체위치_차로", column=@Column(name="NPC1_객체위치_차로")),
            @AttributeOverride(name="객체위치_상대거리", column=@Column(name="NPC1_객체위치_상대거리")),
            @AttributeOverride(name="객체속도", column=@Column(name="NPC1_객체속도")),
            @AttributeOverride(name="객체가감속도", column=@Column(name="NPC1_객체가감속도")),
            @AttributeOverride(name="Trigger_가감속", column=@Column(name="NPC1_Trigger_가감속")),
            @AttributeOverride(name="객체행동_시작", column=@Column(name="NPC1_객체행동_시작")),
            @AttributeOverride(name="객체행동_동작", column=@Column(name="NPC1_객체행동_동작")),
            @AttributeOverride(name="Trigger_동작", column=@Column(name="NPC1_Trigger_동작"))
    })
    private Npc NPC1;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="객체종류", column=@Column(name="NPC2_객체종류")),
            @AttributeOverride(name="객체위치_차로", column=@Column(name="NPC2_객체위치_차로")),
            @AttributeOverride(name="객체위치_상대거리", column=@Column(name="NPC2_객체위치_상대거리")),
            @AttributeOverride(name="객체속도", column=@Column(name="NPC2_객체속도")),
            @AttributeOverride(name="객체가감속도", column=@Column(name="NPC2_객체가감속도")),
            @AttributeOverride(name="Trigger_가감속", column=@Column(name="NPC2_Trigger_가감속")),
            @AttributeOverride(name="객체행동_시작", column=@Column(name="NPC2_객체행동_시작")),
            @AttributeOverride(name="객체행동_동작", column=@Column(name="NPC2_객체행동_동작")),
            @AttributeOverride(name="Trigger_동작", column=@Column(name="NPC2_Trigger_동작"))
    })
    private Npc NPC2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="객체종류", column=@Column(name="NPC3_객체종류")),
            @AttributeOverride(name="객체위치_차로", column=@Column(name="NPC3_객체위치_차로")),
            @AttributeOverride(name="객체위치_상대거리", column=@Column(name="NPC3_객체위치_상대거리")),
            @AttributeOverride(name="객체속도", column=@Column(name="NPC3_객체속도")),
            @AttributeOverride(name="객체가감속도", column=@Column(name="NPC3_객체가감속도")),
            @AttributeOverride(name="Trigger_가감속", column=@Column(name="NPC3_Trigger_가감속")),
            @AttributeOverride(name="객체행동_시작", column=@Column(name="NPC3_객체행동_시작")),
            @AttributeOverride(name="객체행동_동작", column=@Column(name="NPC3_객체행동_동작")),
            @AttributeOverride(name="Trigger_동작", column=@Column(name="NPC3_Trigger_동작"))
    })
    private Npc NPC3;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="객체종류", column=@Column(name="NPC4_객체종류")),
            @AttributeOverride(name="객체위치_차로", column=@Column(name="NPC4_객체위치_차로")),
            @AttributeOverride(name="객체위치_상대거리", column=@Column(name="NPC4_객체위치_상대거리")),
            @AttributeOverride(name="객체속도", column=@Column(name="NPC4_객체속도")),
            @AttributeOverride(name="객체가감속도", column=@Column(name="NPC4_객체가감속도")),
            @AttributeOverride(name="Trigger_가감속", column=@Column(name="NPC4_Trigger_가감속")),
            @AttributeOverride(name="객체행동_시작", column=@Column(name="NPC4_객체행동_시작")),
            @AttributeOverride(name="객체행동_동작", column=@Column(name="NPC4_객체행동_동작")),
            @AttributeOverride(name="Trigger_동작", column=@Column(name="NPC4_Trigger_동작"))
    })
    private Npc NPC4;
    private String 교통상황_LOS;

    @Embedded
    private 자율주행차 자율주행차;

    public Layer4(){
        this.NPC1 = new Npc();
        this.NPC2 = new Npc();
        this.NPC3 = new Npc();
        this.NPC4 = new Npc();
        this.자율주행차 = new 자율주행차();
    }

}
