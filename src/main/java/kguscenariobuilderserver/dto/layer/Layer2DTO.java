package kguscenariobuilderserver.dto.layer;

import com.fasterxml.jackson.annotation.JsonProperty;
import kguscenariobuilderserver.entity.layer.Layer2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Layer2DTO {
    @JsonProperty("중앙분리대")
    private String 중앙분리대;

    @JsonProperty("방호울타리")
    private String 방호울타리;

    @JsonProperty("충격흡수시설")
    private String 충격흡수시설;

    @JsonProperty("연속조명")
    private String 연속조명;

    @JsonProperty("국부조명")
    private String 국부조명;

    @JsonProperty("과속방지턱")
    private String 과속방지턱;

    @JsonProperty("차량신호")
    private String 차량신호;

    @JsonProperty("도로상태 예고")
    private String 도로상태예고;

    @JsonProperty("노면상황 예고")
    private String 노면상황예고;
    
    @JsonProperty("기상상황 예고")
    private String 기상상황예고;

    @JsonProperty("기타주의 예고")
    private String 기타주의예고;

    @JsonProperty("통행금지")
    private String 통행금지;

    @JsonProperty("통행제한")
    private String 통행제한;

    @JsonProperty("금지사항")
    private String 금지사항;

    @JsonProperty("도로지정")
    private String 도로지정;

    @JsonProperty("통행방법")
    private String 통행방법;

    @JsonProperty("중앙선")
    private String 중앙선;

    @JsonProperty("차선")
    private String 차선;

    @JsonProperty("사전예고 표시")
    private String 사전예고표시;

    @JsonProperty("안전속도 표시")
    private String 안전속도표시;

    @JsonProperty("금지구역 표시")
    private String 금지구역표시;

    @JsonProperty("최고제한속도")
    private String 최고제한속도;

    @JsonProperty("-")
    private String 최저제한속도;

    @JsonProperty("보호구역")
    private String 보호구역;

    @JsonProperty("전용도로")
    private String 전용도로;

    public static Layer2DTO toDTO(Layer2 layer2){
        return new Layer2DTO(
                layer2.get중앙분리대(),
                layer2.get방호울타리(),
                layer2.get충격흡수시설(),
                layer2.get연속조명(),
                layer2.get국부조명(),
                layer2.get과속방지턱(),
                layer2.get차량신호(),
                layer2.get도로상태예고(),
                layer2.get노면상황예고(),
                layer2.get기상상황예고(),
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
