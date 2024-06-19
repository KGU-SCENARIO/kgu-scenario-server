package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.layer.*;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidLayer1(Layer1DTO layer1DTO) {
        String 도로_기능과_등급 = layer1DTO.get도로_기능과_등급();
        String 도로유형 = layer1DTO.get도로유형();
        String 차로폭 = layer1DTO.get차로폭();
        String 도로포장 = layer1DTO.get도로포장();

        if (도로_기능과_등급 == null) {
            return false;
        }

        if ("주간선도로".equals(도로_기능과_등급)) {
            if (!"연속류도로".equals(도로유형) || "3.0m".equals(차로폭)) {
                return false;
            }
        }

        if ("비포장".equals(도로포장)) {
            return !"주간선도로".equals(도로_기능과_등급) && !"보조간선도로".equals(도로_기능과_등급);
        }

        return true;
    }

    public boolean isValidLayer2(Layer2DTO layer2DTO) {
        String 보호구역 = layer2DTO.get보호구역();
        int 최고제한속도 = layer2DTO.get최고제한속도();
        String 통행제한 = layer2DTO.get통행제한();
        String 도로지정 = layer2DTO.get도로지정();
        String 통행방법 = layer2DTO.get통행방법();
        String 차선 = layer2DTO.get차선();

        if ("어린이 보호구역".equals(보호구역)) {
            return 최고제한속도 == 30;
        }

        if ("좌회전 금지".equals(통행제한)) {
            return !"비보호 좌회전".equals(통행방법);
        }

        if ("앞지르기 금지".equals(통행제한)) {
            return !"점선".equals(차선);
        }

        if ("자전거 전용도로".equals(도로지정)) {
            return !"일방통행".equals(통행방법) && !"비보호 좌회전".equals(통행방법);
        }

        return true;
    }

    public boolean isValidLayer4(Layer4DTO layer4DTO) {
        // 현재는 유효성 검사를 하지 않습니다.
        return true;
    }

    public boolean isValidLayer5(Layer5DTO layer5DTO) {
        String 시간대 = layer5DTO.get시간대();
        String 조도 = layer5DTO.get조도();
        String 날씨 = layer5DTO.get날씨();

        if ("어둠".equals(조도) && "맑음".equals(날씨)) {
            return !"오전".equals(시간대) && !"오후".equals(시간대);
        }

        return true;
    }
}
