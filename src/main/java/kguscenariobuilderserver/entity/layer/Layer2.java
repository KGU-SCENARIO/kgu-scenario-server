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


    @Column(nullable = false)
    private String median_barrier;

    @Column(nullable = false)
    private String guardrail;

    @Column(nullable = false)
    private String impact_absorbing_facility;

    @Column(nullable = false)
    private String continuous_lighting;

    @Column(nullable = false)
    private String local_lighting;

    @Column(nullable = false)
    private String speed_bump;

    @Column(nullable = false)
    private String vehicle_signal;

    @Column(nullable = false)
    private String road_condition_alert;

    @Column(nullable = false)
    private String pavement_condition_alert;

    @Column(nullable = false)
    private String weather_condition_alert;

    @Column(nullable = false)
    private String other_warning_alerts;

    @Column(nullable = false)
    private String no_entry;

    @Column(nullable = false)
    private String restricted_access;

    @Column(nullable = false)
    private String prohibited_items;

    @Column(nullable = false)
    private String road_designation;

    @Column(nullable = false)
    private String traffic_method;

    @Column(nullable = false)
    private String center_line;

    @Column(nullable = false)
    private String lane_line;

    @Column(nullable = false)
    private String advance_warning_sign;

    @Column(nullable = false)
    private String safe_speed_sign;

    @Column(nullable = false)
    private String no_access_sign;

    @Column(nullable = false)
    private int maximum_speed_limit;

    @Column(nullable = false)
    private String minimum_speed_limit;

    @Column(nullable = false)
    private String protected_zone;

    @Column(nullable = false)
    private String exclusive_road;
}
