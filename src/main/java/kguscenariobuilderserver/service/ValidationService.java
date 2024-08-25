package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.layer.*;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidLayer1(Layer1DTO layer1DTO) {
        String 도로_기능과_등급 = layer1DTO.getRoad_function_and_Grade();
        String 도로유형 = layer1DTO.getRoad_type();
        String 차로폭 = layer1DTO.getLane_width();
        String 도로포장 = layer1DTO.getRoad_surface();
        String 차로수 = layer1DTO.getNumber_of_lanes();

        if (도로_기능과_등급 == null) {
            return false;
        }

        if ("주간선도로".equals(도로_기능과_등급)) {
            if (!"연속류도로".equals(도로유형) || "3.0m".equals(차로폭)) {
                return false;
            }
        }

        if ("비포장".equals(도로포장)) {
            return !"주간선도로".equals(도로_기능과_등급) && !"보조간선도로".equals(도로_기능과_등급) || !"왕복 8차로 이상".equals(차로수);
        }

        return true;
    }

    public boolean isValidLayer2(Layer2DTO layer2DTO) {
        String 보호구역 = layer2DTO.getProtected_zone();
        int 최고제한속도 = layer2DTO.getMaximum_speed_limit();
        String 통행제한 = layer2DTO.getRestricted_access();
        String 도로지정 = layer2DTO.getRoad_designation();
        String 통행방법 = layer2DTO.getTraffic_method();
        String 차선 = layer2DTO.getLane_line();

        if ("어린이 보호구역".equals(보호구역)) {
            return 최고제한속도 == 30;
        }

        if (("좌회전 금지".equals(통행제한) && "비보호 좌회전".equals(통행방법)) ||
                ("앞지르기 금지".equals(통행제한) && "점선".equals(차선)) ||
                ("자전거 전용도로".equals(도로지정) && ("일방통행".equals(통행방법) || "비보호 좌회전".equals(통행방법)))) {
            return false;
        }

        return true;
    }

    public boolean isValidLayer4(Layer4DTO layer4DTO) {
        String speed = layer4DTO.getAv_speed();
        String action = layer4DTO.getAv_action_perform();

        int[] lines = {
                layer4DTO.getNpc1_position_lane(),
                layer4DTO.getNpc2_position_lane(),
                layer4DTO.getNpc3_position_lane(),
                layer4DTO.getNpc4_position_lane()
        };

        String[] actions = {
                layer4DTO.getNpc1_action_perform(),
                layer4DTO.getNpc2_action_perform(),
                layer4DTO.getNpc3_action_perform(),
                layer4DTO.getNpc4_action_perform()
        };


        String[] triggers = {
                layer4DTO.getNpc1_trigger_action(),
                layer4DTO.getNpc2_trigger_action(),
                layer4DTO.getNpc3_trigger_action(),
                layer4DTO.getNpc4_trigger_action()
        };

        for (int i = 0; i < lines.length; i++) {
            if (!isActionAllowedForLine(lines[i], actions[i])) {
                return false;
            }
        }

        for (int i = 0; i < actions.length; i++){
            if ("좌회전".equals(actions[i])){
                if ("적색신호".equals(triggers[i])) return false;
            }
        }


        if ("정지".equals(action)){
            return "0".equals(speed);
        }

        if (isInvalidNpc(layer4DTO.getNpc1_type(), layer4DTO.getNpc1_speed(), layer4DTO.getNpc1_acceleration()) ||
                isInvalidNpc(layer4DTO.getNpc2_type(), layer4DTO.getNpc2_speed(), layer4DTO.getNpc2_acceleration()) ||
                isInvalidNpc(layer4DTO.getNpc3_type(), layer4DTO.getNpc3_speed(), layer4DTO.getNpc3_acceleration()) ||
                isInvalidNpc(layer4DTO.getNpc4_type(), layer4DTO.getNpc4_speed(), layer4DTO.getNpc4_acceleration())) {
            return false;
        }

        if ("0".equals(layer4DTO.getAv_speed()) && "직진".equals(layer4DTO.getAv_action_start())){
            return false;
        }

        int[] npcs_차로 = {
                layer4DTO.getNpc1_position_lane(),
                layer4DTO.getNpc2_position_lane(),
                layer4DTO.getNpc3_position_lane(),
                layer4DTO.getNpc4_position_lane()
        };

        String[] npcs_상대거리 = {
                layer4DTO.getNpc1_relative_distance(),
                layer4DTO.getNpc2_relative_distance(),
                layer4DTO.getNpc3_relative_distance(),
                layer4DTO.getNpc4_relative_distance()
        };

        if(hasDuplicatePosition(npcs_차로,npcs_상대거리)){
            return false;
        }

        return true;
    }

    public boolean isValidLayer5(Layer5DTO layer5DTO) {
        String 시간대 = layer5DTO.getTime_zone();
        String 조도 = layer5DTO.getIllumination();
        String 날씨 = layer5DTO.getWeather();

        if ("어둠".equals(조도) && "맑음".equals(날씨)) {
            return !"오전".equals(시간대) && !"오후".equals(시간대);
        }

        return true;
    }

    public boolean isValidLayer1WithLayer2(Layer1DTO layer1DTO, Layer2DTO layer2DTO){
        String 도로유형 = layer1DTO.getRoad_type();
        String 도로_기능과_등급 = layer1DTO.getRoad_function_and_Grade();
        String 기타주의예고 = layer2DTO.getOther_warning_alerts();
        String 차량신호 = layer2DTO.getVehicle_signal();
        String 과속방지턱 = layer2DTO.getSpeed_bump();

        if("연속류 도로".equals(도로유형)){
            if("있음".equals(과속방지턱)){
                return false;
            }
        }

         if ("단속류 - 회전교차로".equals(도로유형)){
             return "신호 영향 없음".equals(차량신호);
         }

        if("연속류 도로".equals(도로유형) || "교차로 사이구간".equals(도로유형)){
            if(!"신호 영향 없음".equals(차량신호)){
                return false;
            }
        }

        if("연속류 도로".equals(도로유형) || "주간선도로".equals(도로_기능과_등급)){
            if("비보호 좌회전".equals(layer2DTO.getTraffic_method())){
                return false;
            }

            if("자전거".equals(기타주의예고) || "횡단보도".equals(기타주의예고)){
                return false;
            }

            if("교차로 예고".equals(layer2DTO.getRoad_condition_alert())){
                return false;
            }

            if("횡단보도 예고".equals(layer2DTO.getAdvance_warning_sign())){
                return false;
            }

            if("점선".equals(layer2DTO.getCenter_line())){
                return false;
            }

            if(!"해당없음".equals(layer2DTO.getProtected_zone())){
                return false;
            }

            if(layer2DTO.getMaximum_speed_limit() == 30){
                return false;
            }
        }

        if("단속류-4지 교차로".equals(도로유형) || "단속류-3지 교차로".equals(도로유형)){
            if("있음".equals(layer2DTO.getMedian_barrier()) || "있음".equals(과속방지턱) || "신호 영향 없음".equals(차량신호)){
                return false;
            }
        }

        if("주간선도로".equals(도로_기능과_등급)){

            if(!"자동차 전용도로".equals(layer2DTO.getRoad_designation())){
                return false;
            }

            if("직진 금지".equals(layer2DTO.getRestricted_access())){
                return false;
            }

            if("일방통행".equals(layer2DTO.getTraffic_method())){
                return false;
            }

            if("신호 영향 없음".equals(차량신호)){
                return false;
            }
        }
        return true;
    }

    public boolean isValidLayer2WithLayer5(Layer2DTO layer2DTO, Layer5DTO layer5DTO){
        if("있음".equals(layer2DTO.getLocal_lighting()) || "있음".equals(layer2DTO.getContinuous_lighting())){
            return !"어둠".equals(layer5DTO.getIllumination());
        }
        return true;
    }

    public boolean isValidLayer1WithLayer5(Layer1DTO layer1DTO, Layer5DTO layer5DTO){
        String 날씨 = layer5DTO.getWeather();
        if ("마름".equals(layer1DTO.getPavement_condition())){
            return "맑음".equals(날씨) || "흐림".equals(날씨);
        }
        return true;
    }

    public boolean isValidLayer2WithLayer4(Layer2DTO layer2DTO, Layer4DTO layer4DTO){
        String speed1 = layer4DTO.getNpc1_speed();
        String speed2 = layer4DTO.getNpc2_speed();
        String speed3 = layer4DTO.getNpc3_speed();
        String speed4 = layer4DTO.getNpc4_speed();
        String speed5 = layer4DTO.getAv_speed();

        String action1 = layer4DTO.getNpc1_action_perform();
        String action2 = layer4DTO.getNpc2_action_perform();
        String action3 = layer4DTO.getNpc3_action_perform();
        String action4 = layer4DTO.getNpc4_action_perform();
        String action5 = layer4DTO.getAv_action_perform();

        String trigger1 = layer4DTO.getNpc1_trigger_action();
        String trigger2 = layer4DTO.getNpc2_trigger_action();
        String trigger3 = layer4DTO.getNpc3_trigger_action();
        String trigger4 = layer4DTO.getNpc4_trigger_action();

        String 통행제한 = layer2DTO.getRestricted_access();
        String 통행방법 = layer2DTO.getTraffic_method();
        String 차선 = layer2DTO.getLane_line();
        String 차량신호 = layer2DTO.getVehicle_signal();

        if ("실선".equals(차선)){
            return isNotChangeLine(action1) && isNotChangeLine(action2) && isNotChangeLine(action3) && isNotChangeLine(action4) && isNotChangeLine(action5);
        }

        if ("신호 영향 없음".equals(차량신호)){
            return isSignalImpact(trigger1) && isSignalImpact(trigger2) && isSignalImpact(trigger3) && isSignalImpact(trigger4);
        }

        if ("비보호 좌회전".equals(통행방법)){
            return isNotLeftTurnSignal(trigger1) && isNotLeftTurnSignal(trigger2) && isNotLeftTurnSignal(trigger3) && isNotLeftTurnSignal(trigger4);
        }

        if (layer2DTO.getMaximum_speed_limit() == 50){
            return isMaxSpeed(speed1) && isMaxSpeed(speed2) && isMaxSpeed(speed3) && isMaxSpeed(speed4) && isMaxSpeed(speed5);
        }

        if (layer2DTO.getMaximum_speed_limit() == 30){
            return isMinSikSpeed(speed1) && isMinSikSpeed(speed2) && isMinSikSpeed(speed3) && isMinSikSpeed(speed4) && isMinSikSpeed(speed5);
        }

        if ("유턴 금지".equals(통행제한)){
            return isNotUturn(action1) && isNotUturn(action2) && isNotUturn(action3) && isNotUturn(action4) && isNotUturn(action5);
        }

        if ("직진 금지".equals(통행제한)){
            return isNotStraight(action1) && isNotStraight(action2) && isNotStraight(action3) && isNotStraight(action4) && isNotStraight(action5);
        }

        if ("우회전 금지".equals(통행제한)){
            return isNotRightTurn(action1) && isNotRightTurn(action2) && isNotRightTurn(action3) && isNotRightTurn(action4) && isNotRightTurn(action5);
        }

        return true;
    }

    public boolean isValidLayer1WithLayer4(Layer1DTO layer1DTO, Layer4DTO layer4DTO){
        String 도로유형 = layer1DTO.getRoad_type();

        char 차로수 = layer1DTO.getNumber_of_lanes().charAt(3);
        int n = Character.getNumericValue(차로수);

        if (checkNpcPositions(layer4DTO, n)) {
            return false;
        }

        if("연속류 도로".equals(도로유형)){
            if (containsTriggerOrAction(layer4DTO.getNpc1_trigger_action(), layer4DTO.getNpc1_action_perform()) ||
                    containsTriggerOrAction(layer4DTO.getNpc2_trigger_action(), layer4DTO.getNpc2_action_perform()) ||
                    containsTriggerOrAction(layer4DTO.getNpc3_trigger_action(), layer4DTO.getNpc3_action_perform()) ||
                    containsTriggerOrAction(layer4DTO.getNpc4_trigger_action(), layer4DTO.getNpc4_action_perform()) ||
                    containsTriggerOrAction(" ", layer4DTO.getAv_action_perform())) {
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
        return layer4DTO.getNpc1_position_lane() > n ||
                layer4DTO.getNpc2_position_lane() > n ||
                layer4DTO.getNpc3_position_lane() > n ||
                layer4DTO.getNpc4_position_lane() > n ||
                layer4DTO.getAv_lane_position() > n;
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
        return realSpeed <= 60;
    }

    private boolean isMinSikSpeed(String speed){
        int realSpeed = Integer.parseInt(extractBeforeDelimiter(speed,"~"));
        return realSpeed <= 30;
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

    private boolean isSignalImpact(String trigger){
        return "Headway (안전거리 이내)".equals(trigger) || "Headway (안전거리 초과)".equals(trigger) || "시뮬레이션 시간".equals(trigger);
    }

    private boolean isNotUturn(String action){
        return !"유턴".equals(action);
    }

    private boolean isNotChangeLine(String action){
        return !"차선변경".equals(action);
    }

    private boolean isNotStraight(String action){
        return !"직진".equals(action);
    }

    private boolean isNotRightTurn(String action){
        return !"우회전".equals(action);
    }

    private boolean isNotLeftTurnSignal(String trigger){
        return !"좌회전 신호".equals(trigger);
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

    private boolean isActionAllowedForLine(int line, String action){
        if (line != 1){
            return isNotUturn(action);
        }
        return true;
    }
}
