package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kguscenariobuilderserver.entity.layer.Layer2;
import lombok.Builder;

@Builder
public record Layer2DTO(
        @NotBlank
        @JsonProperty("중앙분리대")
        String median_barrier,

        @NotBlank
        @JsonProperty("방호울타리")
        String guardrail,

        @NotBlank
        @JsonProperty("충격흡수시설")
        String impact_absorbing_facility,

        @NotBlank
        @JsonProperty("연속조명")
        String continuous_lighting,

        @NotBlank
        @JsonProperty("국부조명")
        String local_lighting,

        @NotBlank
        @JsonProperty("과속방지턱")
        String speed_bump,

        @NotBlank
        @JsonProperty("차량신호")
        String vehicle_signal,

        @NotBlank
        @JsonProperty("도로상태 예고")
        String road_condition_alert,

        @NotBlank
        @JsonProperty("노면상황 예고")
        String pavement_condition_alert,

        @NotBlank
        @JsonProperty("기상상황 예고")
        String weather_condition_alert,

        @NotBlank
        @JsonProperty("기타주의 예고")
        String other_warning_alerts,

        @NotBlank
        @JsonProperty("통행금지")
        String no_entry,

        @NotBlank
        @JsonProperty("통행제한")
        String restricted_access,

        @NotBlank
        @JsonProperty("금지사항")
        String prohibited_items,

        @NotBlank
        @JsonProperty("도로지정")
        String road_designation,

        @NotBlank
        @JsonProperty("통행방법")
        String traffic_method,

        @NotBlank
        @JsonProperty("중앙선")
        String center_line,

        @NotBlank
        @JsonProperty("차선")
        String lane_line,

        @NotBlank
        @JsonProperty("사전예고 표시")
        String advance_warning_sign,

        @NotBlank
        @JsonProperty("안전속도 표시")
        String safe_speed_sign,

        @NotBlank
        @JsonProperty("금지구역 표시")
        String no_access_sign,

        @NotNull
        @JsonProperty("최고제한속도")
        int maximum_speed_limit,

        @NotBlank
        @JsonProperty("최저제한속도")
        String minimum_speed_limit,

        @NotBlank
        @JsonProperty("보호구역")
        String protected_zone,

        @NotBlank
        @JsonProperty("전용도로")
        String exclusive_road
) {
    public static Layer2DTO from(Layer2 layer2) {
        return Layer2DTO.builder()
                .median_barrier(layer2.getMedian_barrier())
                .guardrail(layer2.getGuardrail())
                .impact_absorbing_facility(layer2.getImpact_absorbing_facility())
                .continuous_lighting(layer2.getContinuous_lighting())
                .local_lighting(layer2.getLocal_lighting())
                .speed_bump(layer2.getSpeed_bump())
                .vehicle_signal(layer2.getVehicle_signal())
                .road_condition_alert(layer2.getRoad_condition_alert())
                .pavement_condition_alert(layer2.getPavement_condition_alert())
                .weather_condition_alert(layer2.getWeather_condition_alert())
                .other_warning_alerts(layer2.getOther_warning_alerts())
                .no_entry(layer2.getNo_entry())
                .restricted_access(layer2.getRestricted_access())
                .prohibited_items(layer2.getProhibited_items())
                .road_designation(layer2.getRoad_designation())
                .traffic_method(layer2.getTraffic_method())
                .center_line(layer2.getCenter_line())
                .lane_line(layer2.getLane_line())
                .advance_warning_sign(layer2.getAdvance_warning_sign())
                .safe_speed_sign(layer2.getSafe_speed_sign())
                .no_access_sign(layer2.getNo_access_sign())
                .maximum_speed_limit(layer2.getMaximum_speed_limit())
                .minimum_speed_limit(layer2.getMinimum_speed_limit())
                .protected_zone(layer2.getProtected_zone())
                .exclusive_road(layer2.getExclusive_road())
                .build();
    }

}
