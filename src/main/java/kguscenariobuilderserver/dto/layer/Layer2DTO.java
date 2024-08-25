package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer2;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Layer2DTO {
    @JsonProperty("중앙분리대")
    private String median_barrier;

    @JsonProperty("방호울타리")
    private String guardrail;

    @JsonProperty("충격흡수시설")
    private String impact_absorbing_facility;

    @JsonProperty("연속조명")
    private String continuous_lighting;

    @JsonProperty("국부조명")
    private String local_lighting;

    @JsonProperty("과속방지턱")
    private String speed_bump;

    @JsonProperty("차량신호")
    private String vehicle_signal;

    @JsonProperty("도로상태 예고")
    private String road_condition_alert;

    @JsonProperty("노면상황 예고")
    private String pavement_condition_alert;
    
    @JsonProperty("기상상황 예고")
    private String weather_condition_alert;

    @JsonProperty("기타주의 예고")
    private String other_warning_alerts;

    @JsonProperty("통행금지")
    private String no_entry;

    @JsonProperty("통행제한")
    private String restricted_access;

    @JsonProperty("금지사항")
    private String prohibited_items;

    @JsonProperty("도로지정")
    private String road_designation;

    @JsonProperty("통행방법")
    private String traffic_method;

    @JsonProperty("중앙선")
    private String center_line;

    @JsonProperty("차선")
    private String lane_line;

    @JsonProperty("사전예고 표시")
    private String advance_warning_sign;

    @JsonProperty("안전속도 표시")
    private String safe_speed_sign;

    @JsonProperty("금지구역 표시")
    private String no_access_sign;

    @JsonProperty("최고제한속도")
    private int maximum_speed_limit;

    @JsonProperty("최저제한속도")
    private String minimum_speed_limit;

    @JsonProperty("보호구역")
    private String protected_zone;

    @JsonProperty("전용도로")
    private String exclusive_road;

    public static Layer2DTO toDTO(Layer2 layer2) {
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
