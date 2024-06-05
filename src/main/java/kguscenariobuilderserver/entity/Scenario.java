package kguscenariobuilderserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Scenario {
    //인덱스 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_num")
    private Long id;

    @OneToOne
    @JoinColumn(name = "layer1_id")
    private Layer1 layer1;
    @OneToOne
    @JoinColumn(name = "layer2_id")
    private Layer2 layer2;
    @OneToOne
    @JoinColumn(name = "layer3_id")
    private Layer3 layer3;
    @OneToOne
    @JoinColumn(name = "layer4_id")
    private Layer4 layer4;
    @OneToOne
    @JoinColumn(name = "layer5_id")
    private Layer5 layer5;
    @OneToOne
    @JoinColumn(name = "layer6_id")
    private Layer6 layer6;
    @OneToOne
    @JoinColumn(name = "layer7_id")
    private Layer7 layer7;
}
