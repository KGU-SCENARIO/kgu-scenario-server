package kguscenariobuilderserver.repository;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.layer.*;
import kguscenariobuilderserver.service.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
@RequiredArgsConstructor
public class ScenarioDAO {
    private final JdbcTemplate jdbcTemplate;
    private final ValidationService validationService;

    public void batchInsertScenarios(InsertScenario insertScenario) {
        Long maxId = findMaxTcId();

        List<Integer> invalidIndexes = IntStream.range(0, insertScenario.getLayer1DTOs().size())
                .parallel()
                .filter(i -> !validationService.isValidLayer1(insertScenario.getLayer1DTOs().get(i))
                        || !validationService.isValidLayer2(insertScenario.getLayer2DTOs().get(i))
                        || !validationService.isValidLayer3(insertScenario.getLayer3DTOs().get(i))
                        || !validationService.isValidLayer4(insertScenario.getLayer4DTOs().get(i))
                        || !validationService.isValidLayer5(insertScenario.getLayer5DTOs().get(i)))
                .boxed()
                .collect(Collectors.toList());

        removeInvalidIndexes(insertScenario.getLayer1DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer2DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer3DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer4DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer5DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer6DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer7DTOs(), invalidIndexes);

        insertLayer1(insertScenario.getLayer1DTOs(), maxId);
        insertLayer2(insertScenario.getLayer2DTOs(), maxId);
        insertLayer3(insertScenario.getLayer3DTOs(), maxId);
        insertLayer4(insertScenario.getLayer4DTOs(), maxId);
        insertLayer5(insertScenario.getLayer5DTOs(), maxId);
        insertLayer6(insertScenario.getLayer6DTOs(), maxId);
        insertLayer7(insertScenario.getLayer7DTOs(), maxId);
        insertScenario(insertScenario.getTc_description(), maxId, insertScenario.getLayer1DTOs().size());
    }

    private <T> void removeInvalidIndexes(List<T> list, List<Integer> invalidIndexes) {
        Set<Integer> invalidIndexSet = new HashSet<>(invalidIndexes);

        List<T> filteredList = IntStream.range(0, list.size())
                .filter(i -> !invalidIndexSet.contains(i))
                .mapToObj(list::get)
                .toList();

        list.clear();
        list.addAll(filteredList);
    }

    private void executeBatchInsert(String sql, BatchPreparedStatementSetter pss) {
        this.jdbcTemplate.batchUpdate(sql, pss);
    }

    private <T> void insertLayer(String sql, List<T> layerDTOs, Long maxId) {
        executeBatchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                T layerDTO = layerDTOs.get(i);
                setPreparedStatementFields(ps, layerDTO, maxId + (long) i + 1);
            }
            public int getBatchSize() {
                return layerDTOs.size();
            }
        });
    }

    private void insertLayer1(final List<Layer1DTO> layer1DTOs, Long maxId) {
        String sql = "insert into Layer1 (id, 도로_기능과_등급, 차로폭, 갓길폭, 도로선형, 도로경사, 차로수, 도로포장, 노면상태, 도로유형) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer1DTOs, maxId);
    }

    private void insertLayer2(final List<Layer2DTO> layer2DTOs, Long maxId) {
        String sql = "insert into Layer2 (id, 중앙분리대, 방호울타리, 충격흡수시설, 연속조명, 국부조명, 과속방지턱, 차량신호, 도로상태예고, 노면상황예고, 기상상황예고, 기타주의예고, 통행금지, 통행제한, 금지사항, 도로지정, 통행방법, 중앙선, 차선, 사전예고표시, 안전속도표시, 금지구역표시, 최고제한속도, 최저제한속도, 보호구역, 전용도로) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer2DTOs, maxId);
    }

    private void insertLayer3(final List<Layer3DTO> layer3DTOs, Long maxId) {
        String sql = "insert into Layer3 (id, 도로공사, 선행사고, 장애물) values (?, ?, ?, ?)";
        insertLayer(sql, layer3DTOs, maxId);
    }

    private void insertLayer4(final List<Layer4DTO> layer4DTOS, Long maxId) {
        String sql = "insert into Layer4 (id, NPC1_객체종류, NPC1_객체위치_차로, NPC1_객체위치_상대거리, NPC1_객체속도, NPC1_객체가감속도, NPC1_Trigger_가감속, NPC1_객체행동_시작, NPC1_객체행동_동작, NPC1_Trigger_동작," +
                "NPC2_객체종류, NPC2_객체위치_차로, NPC2_객체위치_상대거리, NPC2_객체속도, NPC2_객체가감속도, NPC2_Trigger_가감속, NPC2_객체행동_시작, NPC2_객체행동_동작, NPC2_Trigger_동작," +
                "NPC3_객체종류, NPC3_객체위치_차로, NPC3_객체위치_상대거리, NPC3_객체속도, NPC3_객체가감속도, NPC3_Trigger_가감속, NPC3_객체행동_시작, NPC3_객체행동_동작, NPC3_Trigger_동작," +
                "NPC4_객체종류, NPC4_객체위치_차로, NPC4_객체위치_상대거리, NPC4_객체속도, NPC4_객체가감속도, NPC4_Trigger_가감속, NPC4_객체행동_시작, NPC4_객체행동_동작, NPC4_Trigger_동작," +
                "교통상황_LOS, 자율주행차_객체종류, 자율주행차_객체위치_차로, 자율주행차_객체속도, 자율주행차_객체행동_시작, 자율주행차_객체예상행동_동작) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer4DTOS, maxId);
    }

    private void insertLayer5(final List<Layer5DTO> layer5DTOs, Long maxId) {
        String sql = "insert into Layer5 (id, 시간대, 요일, 날씨, 기온, 조도) values (?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer5DTOs, maxId);
    }

    private void insertLayer6(final List<Layer6DTO> layer6DTOs, Long maxId) {
        String sql = "insert into Layer6 (id, Camera센서, Radar센서, LiDAR센서, V2I, V2V, V2P, V2N, V2C, GPS정보, 전자지도정보) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer6DTOs, maxId);
    }

    private void insertLayer7(final List<Layer7DTO> layer7DTOs, Long maxId) {
        String sql = "insert into Layer7 (id, 법ㆍ규제) values (?, ?)";
        executeBatchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer7DTO layer7DTO = layer7DTOs.get(i);
                ps.setLong(1, maxId + (long) i + 1);
                ps.setString(2, layer7DTO.get법ㆍ규제());
            }
            public int getBatchSize() {
                return layer7DTOs.size();
            }
        });
    }

    private void insertScenario(String tc_description, Long maxId,int tc_size) {
        String sql = "insert into Scenario (scenario_id, layer1_id, layer2_id, layer3_id, layer4_id, layer5_id, layer6_id, layer7_id, tc_description, tc_create_at) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        executeBatchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                long id = maxId + (long) i + 1;
                for (int j = 1; j <= 8; j++) {
                    ps.setLong(j, id);
                }
                ps.setString(9, tc_description);
                ps.setTimestamp(10,new Timestamp(System.currentTimeMillis()));
            }
            public int getBatchSize() {
                return tc_size;
            }
        });
    }

    private Long findMaxTcId() {
        Long maxId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM Layer7", Long.class);
        return (maxId == null) ? 0L : maxId;
    }

    private void setPreparedStatementFields(PreparedStatement ps, Object layerDto, Long maxId) throws SQLException {
        Field[] fields = layerDto.getClass().getDeclaredFields();
        ps.setLong(1, maxId);
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

