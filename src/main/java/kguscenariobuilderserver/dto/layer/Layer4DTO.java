package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kguscenariobuilderserver.entity.layer.layer4.Layer4;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public record Layer4DTO (
         /*

        NPC 1

        */
        @NotBlank
        @JsonProperty("NPC1 객체종류")
        String npc1_type,

        @NotNull
        @JsonProperty("NPC1 객체위치-차로")
        int npc1_position_lane,

        @NotBlank
        @JsonProperty("NPC1 객체위치-상대거리")
        String npc1_relative_distance,

        @NotBlank
        @JsonProperty("NPC1 객체속도")
        String npc1_speed,

        @NotBlank
        @JsonProperty("NPC1 객체가감속도")
        String npc1_acceleration,

        @NotBlank
        @JsonProperty("NPC1 Trigger(가감속)")
        String npc1_trigger_acceleration,

        @NotBlank
        @JsonProperty("NPC1 객체행동(시작)")
        String npc1_action_start,

        @NotBlank
        @JsonProperty("NPC1 객체행동(동작)")
        String npc1_action_perform,

        @NotBlank
        @JsonProperty("NPC1 Trigger(동작)")
        String npc1_trigger_action,

        /*

        NPC 2

        */
        @NotBlank
        @JsonProperty("NPC2 객체종류")
        String npc2_type,

        @NotNull
        @JsonProperty("NPC2 객체위치-차로")
        int npc2_position_lane,

        @NotBlank
        @JsonProperty("NPC2 객체위치-상대거리")
        String npc2_relative_distance,

        @NotBlank
        @JsonProperty("NPC2 객체속도")
        String npc2_speed,

        @NotBlank
        @JsonProperty("NPC2 객체가감속도")
        String npc2_acceleration,

        @NotBlank
        @JsonProperty("NPC2 Trigger(가감속)")
        String npc2_trigger_acceleration,

        @NotBlank
        @JsonProperty("NPC2 객체행동(시작)")
        String npc2_action_start,

        @NotBlank
        @JsonProperty("NPC2 객체행동(동작)")
        String npc2_action_perform,

        @NotBlank
        @JsonProperty("NPC2 Trigger(동작)")
        String npc2_trigger_action,

        /*

        NPC 3

        */

        @NotBlank
        @JsonProperty("NPC3 객체종류")
        String npc3_type,

        @NotNull
        @JsonProperty("NPC3 객체위치-차로")
        int npc3_position_lane,

        @NotBlank
        @JsonProperty("NPC3 객체위치-상대거리")
        String npc3_relative_distance,

        @NotBlank
        @JsonProperty("NPC3 객체속도")
        String npc3_speed,

        @NotBlank
        @JsonProperty("NPC3 객체가감속도")
        String npc3_acceleration,

        @NotBlank
        @JsonProperty("NPC3 Trigger(가감속)")
        String npc3_trigger_acceleration,

        @NotBlank
        @JsonProperty("NPC3 객체행동(시작)")
        String npc3_action_start,

        @NotBlank
        @JsonProperty("NPC3 객체행동(동작)")
        String npc3_action_perform,

        @NotBlank
        @JsonProperty("NPC3 Trigger(동작)")
        String npc3_trigger_action,

        /*

        NPC 4

        */

        @NotBlank
        @JsonProperty("NPC4 객체종류")
        String npc4_type,

        @NotNull
        @JsonProperty("NPC4 객체위치-차로")
        int npc4_position_lane,

        @NotBlank
        @JsonProperty("NPC4 객체위치-상대거리")
        String npc4_relative_distance,

        @NotBlank
        @JsonProperty("NPC4 객체속도")
        String npc4_speed,

        @NotBlank
        @JsonProperty("NPC4 객체가감속도")
        String npc4_acceleration,

        @NotBlank
        @JsonProperty("NPC4 Trigger(가감속)")
        String npc4_trigger_acceleration,

        @NotBlank
        @JsonProperty("NPC4 객체행동(시작)")
        String npc4_action_start,

        @NotBlank
        @JsonProperty("NPC4 객체행동(동작)")
        String npc4_action_perform,

        @NotBlank
        @JsonProperty("NPC4 Trigger(동작)")
        String npc4_trigger_action,


        @NotBlank
        @JsonProperty("교통상황(LOS)")
        String traffic_condition_LOS,

        /*

        자율 주행차

        */

        @NotBlank
        @JsonProperty("자율주행차 객체종류")
        String av_type,

        @NotNull
        @JsonProperty("자율주행차 객체위치-차로")
        int av_lane_position,

        @NotBlank
        @JsonProperty("자율주행차 객체속도")
        String av_speed,

        @NotBlank
        @JsonProperty("자율주행차 객체 행동(시작)")
        String av_action_start,

        @NotBlank
        @JsonProperty("자율주행차 객체 예상 행동(동작)")
        String av_action_perform
) {
    public static Layer4DTO from(Layer4 layer4) {
        if (layer4 == null) {
            return null;
        }

        return Layer4DTO.builder()
                .npc1_type(layer4.getNpc1().getType())
                .npc1_position_lane(layer4.getNpc1().getPosition_lane())
                .npc1_relative_distance(layer4.getNpc1().getRelative_distance())
                .npc1_speed(layer4.getNpc1().getSpeed())
                .npc1_acceleration(layer4.getNpc1().getAcceleration())
                .npc1_trigger_acceleration(layer4.getNpc1().getTrigger_acceleration())
                .npc1_action_start(layer4.getNpc1().getAction_start())
                .npc1_action_perform(layer4.getNpc1().getAction_perform())
                .npc1_trigger_action(layer4.getNpc1().getTrigger_action())

                .npc2_type(layer4.getNpc2().getType())
                .npc2_position_lane(layer4.getNpc2().getPosition_lane())
                .npc2_relative_distance(layer4.getNpc2().getRelative_distance())
                .npc2_speed(layer4.getNpc2().getSpeed())
                .npc2_acceleration(layer4.getNpc2().getAcceleration())
                .npc2_trigger_acceleration(layer4.getNpc2().getTrigger_acceleration())
                .npc2_action_start(layer4.getNpc2().getAction_start())
                .npc2_action_perform(layer4.getNpc2().getAction_perform())
                .npc2_trigger_action(layer4.getNpc2().getTrigger_action())

                .npc3_type(layer4.getNpc3().getType())
                .npc3_position_lane(layer4.getNpc3().getPosition_lane())
                .npc3_relative_distance(layer4.getNpc3().getRelative_distance())
                .npc3_speed(layer4.getNpc3().getSpeed())
                .npc3_acceleration(layer4.getNpc3().getAcceleration())
                .npc3_trigger_acceleration(layer4.getNpc3().getTrigger_acceleration())
                .npc3_action_start(layer4.getNpc3().getAction_start())
                .npc3_action_perform(layer4.getNpc3().getAction_perform())
                .npc3_trigger_action(layer4.getNpc3().getTrigger_action())

                .npc4_type(layer4.getNpc4().getType())
                .npc4_position_lane(layer4.getNpc4().getPosition_lane())
                .npc4_relative_distance(layer4.getNpc4().getRelative_distance())
                .npc4_speed(layer4.getNpc4().getSpeed())
                .npc4_acceleration(layer4.getNpc4().getAcceleration())
                .npc4_trigger_acceleration(layer4.getNpc4().getTrigger_acceleration())
                .npc4_action_start(layer4.getNpc4().getAction_start())
                .npc4_action_perform(layer4.getNpc4().getAction_perform())
                .npc4_trigger_action(layer4.getNpc4().getTrigger_action())

                .traffic_condition_LOS(layer4.getTraffic_condition_LOS())

                .av_type(layer4.getAutonomous_vehicle().getAv_type())
                .av_lane_position(layer4.getAutonomous_vehicle().getAv_lane_position())
                .av_speed(layer4.getAutonomous_vehicle().getAv_speed())
                .av_action_start(layer4.getAutonomous_vehicle().getAv_action_start())
                .av_action_perform(layer4.getAutonomous_vehicle().getAv_action_perform())
                .build();
    }


}
