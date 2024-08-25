package kguscenariobuilderserver.entity.layer;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.Scenario;
import lombok.Getter;

@Entity
@Getter
public class Layer2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "layer2")
    private Scenario scenario;

    private String median_barrier;
    private String guardrail;
    private String impact_absorbing_facility;
    private String continuous_lighting;
    private String local_lighting;
    private String speed_bump;
    private String vehicle_signal;
    private String road_condition_alert;
    private String pavement_condition_alert;
    private String weather_condition_alert;
    private String other_warning_alerts;
    private String no_entry;
    private String restricted_access;
    private String prohibited_items;
    private String road_designation;
    private String traffic_method;
    private String center_line;
    private String lane_line;
    private String advance_warning_sign;
    private String safe_speed_sign;
    private String no_access_sign;
    private int maximum_speed_limit;
    private String minimum_speed_limit;
    private String protected_zone;
    private String exclusive_road;

}
