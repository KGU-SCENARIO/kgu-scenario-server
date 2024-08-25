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

    public int batchInsertScenarios(InsertScenario insertScenario) {
        Long maxId = findMaxTcId();

        List<Integer> invalidIndexes = IntStream.range(0, insertScenario.getLayer1DTOs().size())
                .parallel()
                .filter(i -> !validationService.isValidLayer1(insertScenario.getLayer1DTOs().get(i))
                        || !validationService.isValidLayer2(insertScenario.getLayer2DTOs().get(i))
                        || !validationService.isValidLayer4(insertScenario.getLayer4DTOs().get(i))
                        || !validationService.isValidLayer5(insertScenario.getLayer5DTOs().get(i))
                        || !validationService.isValidLayer1WithLayer2(insertScenario.getLayer1DTOs().get(i),insertScenario.getLayer2DTOs().get(i))
                        || !validationService.isValidLayer1WithLayer5(insertScenario.getLayer1DTOs().get(i),insertScenario.getLayer5DTOs().get(i))
                        || !validationService.isValidLayer2WithLayer5(insertScenario.getLayer2DTOs().get(i),insertScenario.getLayer5DTOs().get(i))
                        || !validationService.isValidLayer2WithLayer4(insertScenario.getLayer2DTOs().get(i),insertScenario.getLayer4DTOs().get(i))
                        || !validationService.isValidLayer1WithLayer4(insertScenario.getLayer1DTOs().get(i),insertScenario.getLayer4DTOs().get(i))
                        )
                .boxed()
                .collect(Collectors.toList());

        removeInvalidIndexes(insertScenario.getLayer1DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer2DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer3DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer4DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer5DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer6DTOs(), invalidIndexes);
        removeInvalidIndexes(insertScenario.getLayer7DTOs(), invalidIndexes);

        int size = insertScenario.getLayer1DTOs().size();

        insertLayer1(insertScenario.getLayer1DTOs(), maxId);
        insertLayer2(insertScenario.getLayer2DTOs(), maxId);
        insertLayer3(insertScenario.getLayer3DTOs(), maxId);
        insertLayer4(insertScenario.getLayer4DTOs(), maxId);
        insertLayer5(insertScenario.getLayer5DTOs(), maxId);
        insertLayer6(insertScenario.getLayer6DTOs(), maxId);
        insertLayer7(insertScenario.getLayer7DTOs(), maxId);
        insertScenario(insertScenario.getTc_description(), maxId, size);

        return size;
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
        String sql = "insert into Layer1 (id, road_function_and_Grade, lane_width, shoulder_width, road_alignment, road_gradient, number_of_lanes, road_surface, pavement_condition, road_type) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer1DTOs, maxId);
    }

    private void insertLayer2(final List<Layer2DTO> layer2DTOs, Long maxId) {
        String sql = "insert into Layer2 (id, median_barrier, guardrail, impact_absorbing_facility, continuous_lighting, local_lighting, speed_bump, vehicle_signal, road_condition_alert, pavement_condition_alert, weather_condition_alert, other_warning_alerts, no_entry, restricted_access, prohibited_items, road_designation, traffic_method, center_line, lane_line, advance_warning_sign, safe_speed_sign, no_access_sign, maximum_speed_limit, minimum_speed_limit, protected_zone, exclusive_road) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer2DTOs, maxId);
    }

    private void insertLayer3(final List<Layer3DTO> layer3DTOs, Long maxId) {
        String sql = "insert into Layer3 (id, road_construction, previous_accident, obstacle) values (?, ?, ?, ?)";
        insertLayer(sql, layer3DTOs, maxId);
    }

    private void insertLayer4(final List<Layer4DTO> layer4DTOS, Long maxId) {
        String sql = "insert into Layer4 (id, npc1_type, npc1_position_lane, npc1_relative_distance, npc1_speed, npc1_acceleration, npc1_trigger_acceleration, npc1_action_start, npc1_action_perform, npc1_trigger_action," +
                "npc2_type, npc2_position_lane, npc2_relative_distance, npc2_speed, npc2_acceleration, npc2_trigger_acceleration, npc2_action_start, npc2_action_perform, npc2_trigger_action," +
                "npc3_type, npc3_position_lane, npc3_relative_distance, npc3_speed, npc3_acceleration, npc3_trigger_acceleration, npc3_action_start, npc3_action_perform, npc3_trigger_action," +
                "npc4_type, npc4_position_lane, npc4_relative_distance, npc4_speed, npc4_acceleration, npc4_trigger_acceleration, npc4_action_start, npc4_action_perform, npc4_trigger_action," +
                "traffic_condition_LOS, av_type, av_lane_position, av_speed, av_action_start, av_action_perform) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer4DTOS, maxId);
    }

    private void insertLayer5(final List<Layer5DTO> layer5DTOs, Long maxId) {
        String sql = "insert into Layer5 (id, time_zone, day_of_week, weather, temperature, illumination) values (?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer5DTOs, maxId);
    }

    private void insertLayer6(final List<Layer6DTO> layer6DTOs, Long maxId) {
        String sql = "insert into Layer6 (id, camera_sensor, radar_sensor, lidar_sensor, v2i_communication, v2v_communication, v2p_communication, v2n_communication, v2c_communication, gps_information, electronic_map_information) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        insertLayer(sql, layer6DTOs, maxId);
    }

    private void insertLayer7(final List<Layer7DTO> layer7DTOs, Long maxId) {
        String sql = "insert into Layer7 (id, law_regulation) values (?, ?)";
        executeBatchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer7DTO layer7DTO = layer7DTOs.get(i);
                ps.setLong(1, maxId + (long) i + 1);
                ps.setString(2, layer7DTO.getLaw_regulation());
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

