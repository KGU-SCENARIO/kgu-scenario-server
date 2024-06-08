package kguscenariobuilderserver.entity.layer.layer4;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class 자율주행차 {
    private String 객체종류;
    private String 객체위치_차로;
    private String 객체속도;
    private String 객체행동_시작;
    private String 객체예상행동_동작;
}
