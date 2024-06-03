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
    //조합된 scenario 한줄로 저장
    @OneToOne(fetch = FetchType.LAZY)
    private Layer1 layer1;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer2 layer2;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer3 layer3;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer4 layer4;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer5 layer5;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer6 layer6;
    @OneToOne(fetch = FetchType.LAZY)
    private Layer7 layer7;
}
