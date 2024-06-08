package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Layer4DTO {

    /*

    NPC 1

    */
    @JsonProperty("NPC1 객체종류")
    private String npc1_객체종류;
    @JsonProperty("NPC1 객체위치-차로")
    private String npc1_객체위치_차로;
    @JsonProperty("NPC1 객체위치-상대거리")
    private String npc1_객체위치_상대거리;
    @JsonProperty("NPC1 객체속도")
    private String npc1_객체속도;
    @JsonProperty("NPC1 객체가감속도")
    private String npc1_객체가감속도;
    @JsonProperty("NPC1 Trigger(가감속)")
    private String npc1_Trigger_가감속;
    @JsonProperty("NPC1 객체행동(시작)")
    private String npc1_객체행동_시작;
    @JsonProperty("NPC1 객체행동(동작)")
    private String npc1_객체행동_동작;
    @JsonProperty("NPC1 Trigger(동작)")
    private String npc1_Trigger_동작;

    /*

    NPC 2

    */
    @JsonProperty("NPC2 객체종류")
    private String npc2_객체종류;
    @JsonProperty("NPC2 객체위치-차로")
    private String npc2_객체위치_차로;
    @JsonProperty("NPC2 객체위치-상대거리")
    private String npc2_객체위치_상대거리;
    @JsonProperty("NPC2 객체속도")
    private String npc2_객체속도;
    @JsonProperty("NPC2 객체가감속도")
    private String npc2_객체가감속도;
    @JsonProperty("NPC2 Trigger(가감속)")
    private String npc2_Trigger_가감속;
    @JsonProperty("NPC2 객체행동(시작)")
    private String npc2_객체행동_시작;
    @JsonProperty("NPC2 객체행동(동작)")
    private String npc2_객체행동_동작;
    @JsonProperty("NPC2 Trigger(동작)")
    private String npc2_Trigger_동작;

    /*

    NPC 3

    */
    @JsonProperty("NPC3 객체종류")
    private String npc3_객체종류;
    @JsonProperty("NPC3 객체위치-차로")
    private String npc3_객체위치_차로;
    @JsonProperty("NPC3 객체위치-상대거리")
    private String npc3_객체위치_상대거리;
    @JsonProperty("NPC3 객체속도")
    private String npc3_객체속도;
    @JsonProperty("NPC3 객체가감속도")
    private String npc3_객체가감속도;
    @JsonProperty("NPC3 Trigger(가감속)")
    private String npc3_Trigger_가감속;
    @JsonProperty("NPC3 객체행동(시작)")
    private String npc3_객체행동_시작;
    @JsonProperty("NPC3 객체행동(동작)")
    private String npc3_객체행동_동작;
    @JsonProperty("NPC3 Trigger(동작)")
    private String npc3_Trigger_동작;

    /*

    NPC 4

    */
    @JsonProperty("NPC4 객체종류")
    private String npc4_객체종류;
    @JsonProperty("NPC4 객체위치-차로")
    private String npc4_객체위치_차로;
    @JsonProperty("NPC4 객체위치-상대거리")
    private String npc4_객체위치_상대거리;
    @JsonProperty("NPC4 객체속도")
    private String npc4_객체속도;
    @JsonProperty("NPC4 객체가감속도")
    private String npc4_객체가감속도;
    @JsonProperty("NPC4 Trigger(가감속)")
    private String npc4_Trigger_가감속;
    @JsonProperty("NPC4 객체행동(시작)")
    private String npc4_객체행동_시작;
    @JsonProperty("NPC4 객체행동(동작)")
    private String npc4_객체행동_동작;
    @JsonProperty("NPC4 Trigger(동작)")
    private String npc4_Trigger_동작;

    /*

    자율 주행차

    */
    private String 객체종류;
    @JsonProperty("객체위치-차로")
    private String 객체위치_차로;
    private String 객체속도;
    @JsonProperty("객체 행동(시작)")
    private String 객체행동_시작;
    @JsonProperty("객체 예상 행동(동작)")
    private String 객체예상행동_동작;
}
