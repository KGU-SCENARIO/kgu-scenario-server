package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class 자율주행차 {
    private String 자율주행차_객체종류;
    private int 자율주행차_객체위치_차로;
    private String 자율주행차_객체속도;
    private String 자율주행차_객체행동_시작;
    private String 자율주행차_객체예상행동_동작;
}
