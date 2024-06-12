package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.layer4.Layer4;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer4DTO {

    /*

    NPC 1

    */
    @JsonProperty("NPC1 객체종류")
    private String npc1_객체종류;
    @JsonProperty("NPC1 객체위치-차로")
    private int npc1_객체위치_차로;
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
    private int npc2_객체위치_차로;
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
    private int npc3_객체위치_차로;
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
    private int npc4_객체위치_차로;
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


    @JsonProperty("교통상황(LOS)")
    private String 교통상황_LOS;

    /*

    자율 주행차

    */
    @JsonProperty("자율주행차 객체종류")
    private String 자율주행차_객체종류;
    @JsonProperty("자율주행차 객체위치-차로")
    private int 자율주행차_객체위치_차로;
    @JsonProperty("자율주행차 객체속도")
    private String 자율주행차_객체속도;
    @JsonProperty("자율주행차 객체 행동(시작)")
    private String 자율주행차_객체행동_시작;
    @JsonProperty("자율주행차 객체 예상 행동(동작)")
    private String 자율주행차_객체예상행동_동작;


    public static Layer4DTO toDTO(Layer4 layer4) {
        if (layer4 == null) {
            return null;
        }

        return Layer4DTO.builder()
                .npc1_객체위치_차로(layer4.getNPC1().get객체위치_차로())
                .npc1_객체위치_상대거리(layer4.getNPC1().get객체위치_상대거리())
                .npc1_객체속도(layer4.getNPC1().get객체속도())
                .npc1_객체가감속도(layer4.getNPC1().get객체가감속도())
                .npc1_Trigger_가감속(layer4.getNPC1().getTrigger_가감속())
                .npc1_객체행동_시작(layer4.getNPC1().get객체행동_시작())
                .npc1_객체행동_동작(layer4.getNPC1().get객체행동_동작())
                .npc1_Trigger_동작(layer4.getNPC1().getTrigger_동작())
                .npc2_객체종류(layer4.getNPC2().get객체종류())
                .npc2_객체위치_차로(layer4.getNPC2().get객체위치_차로())
                .npc2_객체위치_상대거리(layer4.getNPC2().get객체위치_상대거리())
                .npc2_객체속도(layer4.getNPC2().get객체속도())
                .npc2_객체가감속도(layer4.getNPC2().get객체가감속도())
                .npc2_Trigger_가감속(layer4.getNPC2().getTrigger_가감속())
                .npc2_객체행동_시작(layer4.getNPC2().get객체행동_시작())
                .npc2_객체행동_동작(layer4.getNPC2().get객체행동_동작())
                .npc2_Trigger_동작(layer4.getNPC2().getTrigger_동작())
                .npc3_객체종류(layer4.getNPC3().get객체종류())
                .npc3_객체위치_차로(layer4.getNPC3().get객체위치_차로())
                .npc3_객체위치_상대거리(layer4.getNPC3().get객체위치_상대거리())
                .npc3_객체속도(layer4.getNPC3().get객체속도())
                .npc3_객체가감속도(layer4.getNPC3().get객체가감속도())
                .npc3_Trigger_가감속(layer4.getNPC3().getTrigger_가감속())
                .npc3_객체행동_시작(layer4.getNPC3().get객체행동_시작())
                .npc3_객체행동_동작(layer4.getNPC3().get객체행동_동작())
                .npc3_Trigger_동작(layer4.getNPC3().getTrigger_동작())
                .npc4_객체종류(layer4.getNPC4().get객체종류())
                .npc4_객체위치_차로(layer4.getNPC4().get객체위치_차로())
                .npc4_객체위치_상대거리(layer4.getNPC4().get객체위치_상대거리())
                .npc4_객체속도(layer4.getNPC4().get객체속도())
                .npc4_객체가감속도(layer4.getNPC4().get객체가감속도())
                .npc4_Trigger_가감속(layer4.getNPC4().getTrigger_가감속())
                .npc4_객체행동_시작(layer4.getNPC4().get객체행동_시작())
                .npc4_객체행동_동작(layer4.getNPC4().get객체행동_동작())
                .npc4_Trigger_동작(layer4.getNPC4().getTrigger_동작())
                .자율주행차_객체종류(layer4.get자율주행차().get자율주행차_객체종류())
                .자율주행차_객체위치_차로(layer4.get자율주행차().get자율주행차_객체위치_차로())
                .자율주행차_객체속도(layer4.get자율주행차().get자율주행차_객체속도())
                .자율주행차_객체행동_시작(layer4.get자율주행차().get자율주행차_객체행동_시작())
                .자율주행차_객체예상행동_동작(layer4.get자율주행차().get자율주행차_객체예상행동_동작())
                .build();
    }


}
