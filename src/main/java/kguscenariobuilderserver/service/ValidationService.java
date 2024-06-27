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

        if ("좌회전 금지".equals(통행제한) && "비보호 좌회전".equals(통행방법)) {
            return false;
        }

        if ("앞지르기 금지".equals(통행제한) && "점선".equals(차선)) {
            return false;
        }

        if ("자전거 전용도로".equals(도로지정) && ("일방통행".equals(통행방법) || "비보호 좌회전".equals(통행방법))) {
            return false;
        }

        return true;
    }

    public boolean isValidLayer4(Layer4DTO layer4DTO) {
        if (isInvalidNpc(layer4DTO.getNpc1_객체종류(), layer4DTO.getNpc1_객체속도(), layer4DTO.getNpc1_객체가감속도()) ||
                isInvalidNpc(layer4DTO.getNpc2_객체종류(), layer4DTO.getNpc2_객체속도(), layer4DTO.getNpc2_객체가감속도()) ||
                isInvalidNpc(layer4DTO.getNpc3_객체종류(), layer4DTO.getNpc3_객체속도(), layer4DTO.getNpc3_객체가감속도()) ||
                isInvalidNpc(layer4DTO.getNpc4_객체종류(), layer4DTO.getNpc4_객체속도(), layer4DTO.getNpc4_객체가감속도())) {
            return false;
        }

        if ("0".equals(layer4DTO.get자율주행차_객체속도()) && "직진".equals(layer4DTO.get자율주행차_객체행동_시작())){
            return false;
        }

        int[] npcs_차로 = {
                layer4DTO.getNpc1_객체위치_차로(),
                layer4DTO.getNpc2_객체위치_차로(),
                layer4DTO.getNpc3_객체위치_차로(),
                layer4DTO.getNpc4_객체위치_차로()
        };

        String[] npcs_상대거리 = {
                layer4DTO.getNpc1_객체위치_상대거리(),
                layer4DTO.getNpc2_객체위치_상대거리(),
                layer4DTO.getNpc3_객체위치_상대거리(),
                layer4DTO.getNpc4_객체위치_상대거리()
        };

        if(hasDuplicatePosition(npcs_차로,npcs_상대거리)){
            return false;
        }

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

    public boolean isValidLayer1WithLayer2(Layer1DTO layer1DTO, Layer2DTO layer2DTO){
        String 도로유형 = layer1DTO.get도로유형();
        String 도로_기능과_등급 = layer1DTO.get도로_기능과_등급();
        String 기타주의예고 = layer2DTO.get기타주의예고();
        String 차량신호 = layer2DTO.get차량신호();
        String 과속방지턱 = layer2DTO.get과속방지턱();

        if("연속류 도로".equals(도로유형)){
            if("있음".equals(과속방지턱)){
                return false;
            }
        }

        if("연속류 도로".equals(도로유형) || "교차로 사이구간".equals(도로유형)){
            if(!"신호 영향 없음".equals(차량신호)){
                return false;
            }
        }

        if("연속류 도로".equals(도로유형) || "주간선도로".equals(도로_기능과_등급)){
            if("비보호 좌회전".equals(layer2DTO.get통행방법())){
                return false;
            }

            if("자전거".equals(기타주의예고) || "횡단보도".equals(기타주의예고)){
                return false;
            }

            if("교차로 예고".equals(layer2DTO.get도로상태예고())){
                return false;
            }

            if("횡단보도 예고".equals(layer2DTO.get사전예고표시())){
                return false;
            }

            if("점선".equals(layer2DTO.get중앙선())){
                return false;
            }

            if(!"해당없음".equals(layer2DTO.get보호구역())){
                return false;
            }

            if(layer2DTO.get최고제한속도() == 30){
                return false;
            }
        }

        if("단속류-4지 교차로".equals(도로유형) || "단속류-3지 교차로".equals(도로유형)){
            if("있음".equals(layer2DTO.get중앙분리대()) || "있음".equals(과속방지턱) || "신호 영향 없음".equals(차량신호)){
                return false;
            }
        }

        if("주간선도로".equals(도로_기능과_등급)){

            if(!"자동차 전용도로".equals(layer2DTO.get도로지정())){
                return false;
            }

            if("직진 금지".equals(layer2DTO.get통행제한())){
                return false;
            }

            if("일방통행".equals(layer2DTO.get통행방법())){
                return false;
            }

            if("신호 영향 없음".equals(차량신호)){
                return false;
            }
        }
        return true;
    }

    public boolean isValidLayer2WithLayer5(Layer2DTO layer2DTO, Layer5DTO layer5DTO){
        if("있음".equals(layer2DTO.get국부조명()) || "있음".equals(layer2DTO.get연속조명())){
            return !"어둠".equals(layer5DTO.get조도());
        }
        return true;
    }

    public boolean isValidLayer1WithLayer5(Layer1DTO layer1DTO, Layer5DTO layer5DTO){
        String 날씨 = layer5DTO.get날씨();
        if ("마름".equals(layer1DTO.get노면상태())){
            return "맑음".equals(날씨) || "흐림".equals(날씨);
        }
        return true;
    }

    public boolean isValidLayer2WithLayer4(Layer2DTO layer2DTO, Layer4DTO layer4DTO){
        String speed1 = layer4DTO.getNpc1_객체속도();
        String speed2 = layer4DTO.getNpc2_객체속도();
        String speed3 = layer4DTO.getNpc3_객체속도();
        String speed4 = layer4DTO.getNpc4_객체속도();
        String speed5 = layer4DTO.get자율주행차_객체속도();

        if (layer2DTO.get최고제한속도() == 50){
            return isMaxSpeed(speed1) && isMaxSpeed(speed2) && isMaxSpeed(speed3) && isMaxSpeed(speed4) && isMaxSpeed(speed5);
        }

        return true;
    }

    public boolean isValidLayer1WithLayer4(Layer1DTO layer1DTO, Layer4DTO layer4DTO){
        String 도로유형 = layer1DTO.get도로유형();

        char 차로수 = layer1DTO.get차로수().charAt(3);
        int n = Character.getNumericValue(차로수);

        if (checkNpcPositions(layer4DTO, n)) {
            return false;
        }

        if("연속류 도로".equals(도로유형)){
            if (containsTriggerOrAction(layer4DTO.getNpc1_Trigger_동작(), layer4DTO.getNpc1_객체행동_동작()) ||
                    containsTriggerOrAction(layer4DTO.getNpc2_Trigger_동작(), layer4DTO.getNpc2_객체행동_동작()) ||
                    containsTriggerOrAction(layer4DTO.getNpc3_Trigger_동작(), layer4DTO.getNpc3_객체행동_동작()) ||
                    containsTriggerOrAction(layer4DTO.getNpc4_Trigger_동작(), layer4DTO.getNpc4_객체행동_동작()) ||
                    containsTriggerOrAction(" ", layer4DTO.get자율주행차_객체예상행동_동작())) {
                return false;
            }
        }
        return true;
    }

    private boolean containsTriggerOrAction(String trigger, String action) {
        return ("시뮬레이션 시간".equals(trigger) || trigger.startsWith("Headway") || trigger.equals(" ")) &&
                (action.equals("좌회전(진입)") || action.equals("우회전(진출)") || action.equals("유턴"));
    }

    private boolean checkNpcPositions(Layer4DTO layer4DTO, int n) {
        return layer4DTO.getNpc1_객체위치_차로() > n ||
                layer4DTO.getNpc2_객체위치_차로() > n ||
                layer4DTO.getNpc3_객체위치_차로() > n ||
                layer4DTO.getNpc4_객체위치_차로() > n ||
                layer4DTO.get자율주행차_객체위치_차로() > n;
    }

    private String extractBeforeDelimiter(String input, String delimiter) {
        int delimiterIndex = input.indexOf(delimiter);
        if (delimiterIndex != -1) {
            return input.substring(0, delimiterIndex).trim();
        }
        return input.trim();
    }

    private boolean isMaxSpeed(String speed){
        int realSpeed = Integer.parseInt(extractBeforeDelimiter(speed,"~"));
        return realSpeed < 70;
    }

    private boolean hasDuplicatePosition(int[] lanes, String[] distances) {
        for (int i = 0; i < lanes.length; i++) {
            for (int j = i + 1; j < lanes.length; j++) {
                if (lanes[i] == lanes[j] && distances[i].equals(distances[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSpeedInRange(String speed){
        int realSpeed = Integer.parseInt(extractBeforeDelimiter(speed,"~"));
        return realSpeed >= 40;
    }

    private boolean isValidAcceleration(String acceleration){
        int realSpeed = Integer.parseInt(extractBeforeDelimiter(acceleration,"~"));
        return realSpeed > 10 || realSpeed < -10;
    }

    private boolean isInvalidNpc(String type, String speed, String acceleration) {
        return "보행자".equals(type) && (isSpeedInRange(speed) || isValidAcceleration(acceleration));
    }
}
