package kguscenariobuilderserver.dto;

import kguscenariobuilderserver.entity.Layer2;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Layer2Dto {
    private String 중앙분리대;
    private String 방호울타리;
    private String 충격흡수시설;
    private String 연속조명;
    private String 국부조명;
    private String 과속방지턱;
    private String 차량신호;
    private String 도로상태예고;
    private String 노면상황예고;
    private String 기타주의예고;
    private String 통행금지;
    private String 통행제한;
    private String 금지사항;
    private String 도로지정;
    private String 통행방법;
    private String 중앙선;
    private String 차선;
    private String 사전예고표시;
    private String 안전속도표시;
    private String 금지구역표시;
    private String 최고제한속도;
    private String 최저제한속도;
    private String 보호구역;
    private String 전용도로;

    public static Layer2Dto toDto(Layer2 layer2){
        return new Layer2Dto(
                layer2.get중앙분리대(),
                layer2.get방호울타리(),
                layer2.get충격흡수시설(),
                layer2.get연속조명(),
                layer2.get국부조명(),
                layer2.get과속방지턱(),
                layer2.get차량신호(),
                layer2.get도로상태예고(),
                layer2.get노면상황예고(),
                layer2.get기타주의예고(),
                layer2.get통행금지(),
                layer2.get통행제한(),
                layer2.get금지사항(),
                layer2.get도로지정(),
                layer2.get통행방법(),
                layer2.get중앙선(),
                layer2.get차선(),
                layer2.get사전예고표시(),
                layer2.get안전속도표시(),
                layer2.get금지구역표시(),
                layer2.get최고제한속도(),
                layer2.get최저제한속도(),
                layer2.get보호구역(),
                layer2.get전용도로()
        );
    }
}
