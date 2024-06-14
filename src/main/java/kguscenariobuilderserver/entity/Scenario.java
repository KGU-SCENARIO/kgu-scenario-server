package kguscenariobuilderserver.entity;

import jakarta.persistence.*;
import kguscenariobuilderserver.entity.layer.*;
import kguscenariobuilderserver.entity.layer.layer4.Layer4;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Scenario {
    //인덱스 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer1_id")
    private Layer1 layer1;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer2_id")
    private Layer2 layer2;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer3_id")
    private Layer3 layer3;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer4_id")
    private Layer4 layer4;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer5_id")
    private Layer5 layer5;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer6_id")
    private Layer6 layer6;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "layer7_id")
    private Layer7 layer7;

    private String tc_description;

    private Timestamp tc_create_at;

}
