package kguscenariobuilderserver.repository;

import kguscenariobuilderserver.dto.layer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScenarioDAO {
    private final JdbcTemplate jdbcTemplate;

    private void batchInsert(String sql, BatchPreparedStatementSetter pss) {
        this.jdbcTemplate.batchUpdate(sql, pss);
    }

    public void insertLayer1(final List<Layer1DTO> layer1DTOs,Long maxId) {
        String sql = "insert into Layer1 (id, 도로_기능과_등급, 차로폭, 갓길폭, 도로선형, 도로경사, 차로수, 도로포장, 노면상태, 도로유형) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer1DTO layer1DTO = layer1DTOs.get(i);
                setPreparedStatementFields(ps,layer1DTO, maxId +(long) i+1);
            }
            public int getBatchSize() {
                return layer1DTOs.size();
            }
        });
    }

    public void insertLayer2(final List<Layer2DTO> layer2DTOs, Long maxId) {
        String sql = "insert into Layer2 (id, 중앙분리대, 방호울타리, 충격흡수시설, 연속조명, 국부조명, 과속방지턱, 차량신호, 도로상태예고, 노면상황예고, 기상상황예고, 기타주의예고, 통행금지, 통행제한, 금지사항, 도로지정, 통행방법, 중앙선, 차선, 사전예고표시, 안전속도표시, 금지구역표시, 최고제한속도, 최저제한속도, 보호구역, 전용도로) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer2DTO layer2DTO = layer2DTOs.get(i);
                setPreparedStatementFields(ps,layer2DTO, maxId +(long) i+1);
            }
            public int getBatchSize() {
                return layer2DTOs.size();
            }
        });
    }

    public void insertLayer3(final List<Layer3DTO> layer3DTOs, Long maxId) {
        String sql = "insert into Layer3 (id, 도로공사, 선행사고, 장애물) values (?, ?, ?, ?)";
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer3DTO layer3DTO = layer3DTOs.get(i);
                setPreparedStatementFields(ps,layer3DTO, maxId +(long) i+1);
            }
            public int getBatchSize() {
                return layer3DTOs.size();
            }
        });
    }

    public void insertLayer4(final List<Layer4DTO> layer4DTOS, Long maxId) {
        String sql = "insert into Layer4 (id, NPC1_객체종류, NPC1_객체위치_차로, NPC1_객체위치_상대거리, NPC1_객체속도, NPC1_객체가감속도, NPC1_Trigger_가감속, NPC1_객체행동_시작, NPC1_객체행동_동작, NPC1_Trigger_동작," +
                     "NPC2_객체종류, NPC2_객체위치_차로, NPC2_객체위치_상대거리, NPC2_객체속도, NPC2_객체가감속도, NPC2_Trigger_가감속, NPC2_객체행동_시작, NPC2_객체행동_동작, NPC2_Trigger_동작,"+
                     "NPC3_객체종류, NPC3_객체위치_차로, NPC3_객체위치_상대거리, NPC3_객체속도, NPC3_객체가감속도, NPC3_Trigger_가감속, NPC3_객체행동_시작, NPC3_객체행동_동작, NPC3_Trigger_동작,"+
                     "NPC4_객체종류, NPC4_객체위치_차로, NPC4_객체위치_상대거리, NPC4_객체속도, NPC4_객체가감속도, NPC4_Trigger_가감속, NPC4_객체행동_시작, NPC4_객체행동_동작, NPC4_Trigger_동작,"+
                     "교통상황_LOS, 자율주행차_객체종류, 자율주행차_객체위치_차로, 자율주행차_객체속도, 자율주행차_객체행동_시작, 자율주행차_객체예상행동_동작) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Long finalMaxId = maxId;
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer4DTO layer4DTO = layer4DTOS.get(i);
                setPreparedStatementFields(ps,layer4DTO, maxId +(long) i+1);

            }
            public int getBatchSize() {
                return layer4DTOS.size();
            }
        });
    }

    public void insertLayer5(final List<Layer5DTO> layer5DTOs, Long maxId) {
        String sql = "insert into Layer5 (id, 시간대, 요일, 날씨, 기온, 조도) values (?, ?, ?, ?, ?, ?)";
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer5DTO layer5DTO = layer5DTOs.get(i);
                setPreparedStatementFields(ps,layer5DTO, maxId +(long) i+1);
            }
            public int getBatchSize() {
                return layer5DTOs.size();
            }
        });
    }

    public void insertLayer6(final List<Layer6DTO> layer6DTOs, Long maxId) {
        String sql = "insert into Layer6 (id, Camera센서, Radar센서, LiDAR센서, V2I, V2V, V2P, V2N, V2C, GPS정보, 전자지도정보) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer6DTO layer6DTO = layer6DTOs.get(i);
                setPreparedStatementFields(ps,layer6DTO, maxId +(long) i+1);
            }
            public int getBatchSize() {
                return layer6DTOs.size();
            }
        });
    }

    public void insertLayer7(final List<Layer7DTO> layer7DTOs, Long maxId) {
        String sql = "insert into Layer7 (id, 법ㆍ규제) values (?, ?)";

        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer7DTO layer7DTO = layer7DTOs.get(i);
                ps.setLong(1, maxId +(long) i+1);
                ps.setString(2, layer7DTO.get법ㆍ규제());
            }

            public int getBatchSize() {
                return layer7DTOs.size();
            }
        });
    }

    public void insertScenario(int scenarioSize,Long maxId){
        String sql = "insert into Scenario (layer1_id, layer2_id, layer3_id, layer4_id, layer5_id, layer6_id, layer7_id) values (?, ?, ?, ?, ?, ?, ?)";
        batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1,maxId +(long) i+1);
                ps.setLong(2, maxId +(long) i+1);
                ps.setLong(3, maxId +(long) i+1);
                ps.setLong(4, maxId +(long) i+1);
                ps.setLong(5, maxId +(long) i+1);
                ps.setLong(6, maxId +(long) i+1);
                ps.setLong(7, maxId +(long) i+1);

            }

            public int getBatchSize() {
                return scenarioSize;
            }
        });
    }

    public Long maxId(){
        Long maxId =  jdbcTemplate.queryForObject("SELECT MAX(id) FROM Layer7", Long.class);
        if(maxId == null) maxId = 0L;

        return maxId;
    }

    private void setPreparedStatementFields(PreparedStatement ps, Object layerDto,Long maxId) throws SQLException {
        Field[] fields = layerDto.getClass().getDeclaredFields();
        ps.setLong(1,maxId);
        for (int j = 0; j < fields.length; j++) {
            fields[j].setAccessible(true);
            try {
                ps.setObject(j + 2, fields[j].get(layerDto));
            } catch (IllegalAccessException e) {
                throw new SQLException(e);
            }
        }
    }

}
