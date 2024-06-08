package kguscenariobuilderserver.repository;

import kguscenariobuilderserver.dto.layer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScenarioDAO {
    private final JdbcTemplate jdbcTemplate;

    private int[] batchInsert(String sql, BatchPreparedStatementSetter pss) {
        return this.jdbcTemplate.batchUpdate(sql, pss);
    }

    public int[] insertLayer1(final List<Layer1DTO> layer1DTOs) {
        String sql = "insert into Layer1 (도로_기능과_등급, 차로폭, 갓길폭, 도로선형, 도로경사, 차로수, 도로포장, 노면상태, 도로유형) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer1DTO layer1DTO = layer1DTOs.get(i);
                ps.setString(1, layer1DTO.get도로_기능과_등급());
                ps.setString(2, layer1DTO.get차로폭());
                ps.setString(3, layer1DTO.get갓길폭());
                ps.setString(4, layer1DTO.get도로선형());
                ps.setString(5, layer1DTO.get도로경사());
                ps.setString(6, layer1DTO.get차로수());
                ps.setString(7, layer1DTO.get도로포장());
                ps.setString(8, layer1DTO.get노면상태());
                ps.setString(9, layer1DTO.get도로유형());
            }
            public int getBatchSize() {
                return layer1DTOs.size();
            }
        });
    }

    public int[] insertLayer2(final List<Layer2DTO> layer2DTOs) {
        String sql = "insert into Layer2 (중앙분리대, 방호울타리, 충격흡수시설, 연속조명, 국부조명, 과속방지턱, 차량신호, 도로상태예고, 노면상황예고, 기타주의예고, 통행금지, 통행제한, 금지사항, 도로지정, 통행방법, 중앙선, 차선, 사전예고표시, 안전속도표시, 금지구역표시, 최고제한속도, 최저제한속도, 보호구역, 전용도로) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer2DTO layer2DTO = layer2DTOs.get(i);
                ps.setString(1, layer2DTO.get중앙분리대());
                ps.setString(2, layer2DTO.get방호울타리());
                ps.setString(3, layer2DTO.get충격흡수시설());
                ps.setString(4, layer2DTO.get연속조명());
                ps.setString(5, layer2DTO.get국부조명());
                ps.setString(6, layer2DTO.get과속방지턱());
                ps.setString(7, layer2DTO.get차량신호());
                ps.setString(8, layer2DTO.get도로상태예고());
                ps.setString(9, layer2DTO.get노면상황예고());
                ps.setString(10, layer2DTO.get기타주의예고());
                ps.setString(11, layer2DTO.get통행금지());
                ps.setString(12, layer2DTO.get통행제한());
                ps.setString(13, layer2DTO.get금지사항());
                ps.setString(14, layer2DTO.get도로지정());
                ps.setString(15, layer2DTO.get통행방법());
                ps.setString(16, layer2DTO.get중앙선());
                ps.setString(17, layer2DTO.get차선());
                ps.setString(18, layer2DTO.get사전예고표시());
                ps.setString(19, layer2DTO.get안전속도표시());
                ps.setString(20, layer2DTO.get금지구역표시());
                ps.setString(21, layer2DTO.get최고제한속도());
                ps.setString(22, layer2DTO.get최저제한속도());
                ps.setString(23, layer2DTO.get보호구역());
                ps.setString(24, layer2DTO.get전용도로());
            }
            public int getBatchSize() {
                return layer2DTOs.size();
            }
        });
    }

    public int[] insertLayer3(final List<Layer3DTO> layer3DTOs) {
        String sql = "insert into Layer3 (도로공사, 선행사고, 장애물) values (?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer3DTO layer3DTO = layer3DTOs.get(i);
                ps.setString(1, layer3DTO.get도로공사());
                ps.setString(2, layer3DTO.get선행사고());
                ps.setString(3, layer3DTO.get장애물());
            }
            public int getBatchSize() {
                return layer3DTOs.size();
            }
        });
    }

    public int[] insertLayer4(final List<Layer4DTO> layer4DTOS) {
        String sql = "insert into Test (NPC1_객체종류, NPC1_객체위치_차로, NPC1_객체위치_상대거리, NPC1_객체속도, NPC1_객체가감속도, NPC1_Trigger_가감속, NPC1_객체행동_시작, NPC1_객체행동_동작, NPC1_Trigger_동작," +
                     "NPC2_객체종류, NPC2_객체위치_차로, NPC2_객체위치_상대거리, NPC2_객체속도, NPC2_객체가감속도, NPC2_Trigger_가감속, NPC2_객체행동_시작, NPC2_객체행동_동작, NPC2_Trigger_동작,"+
                     "NPC3_객체종류, NPC3_객체위치_차로, NPC3_객체위치_상대거리, NPC3_객체속도, NPC3_객체가감속도, NPC3_Trigger_가감속, NPC3_객체행동_시작, NPC3_객체행동_동작, NPC3_Trigger_동작,"+
                     "NPC4_객체종류, NPC4_객체위치_차로, NPC4_객체위치_상대거리, NPC4_객체속도, NPC4_객체가감속도, NPC4_Trigger_가감속, NPC4_객체행동_시작, NPC4_객체행동_동작, NPC4_Trigger_동작,"+
                     "객체종류, 객체위치_차로, 객체속도, 객체행동_시작, 객체예상행동_동작) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer4DTO layer4DTO = layer4DTOS.get(i);
                ps.setString(1, layer4DTO.getNpc1_객체종류());
                ps.setString(2, layer4DTO.getNpc1_객체위치_차로());
                ps.setString(3, layer4DTO.getNpc1_객체위치_상대거리());
                ps.setString(4, layer4DTO.getNpc1_객체속도());
                ps.setString(5, layer4DTO.getNpc1_객체가감속도());
                ps.setString(6, layer4DTO.getNpc1_Trigger_가감속());
                ps.setString(7, layer4DTO.getNpc1_객체행동_시작());
                ps.setString(8, layer4DTO.getNpc1_객체행동_동작());
                ps.setString(9, layer4DTO.getNpc1_Trigger_동작());

                ps.setString(10, layer4DTO.getNpc2_객체종류());
                ps.setString(11, layer4DTO.getNpc2_객체위치_차로());
                ps.setString(12, layer4DTO.getNpc2_객체위치_상대거리());
                ps.setString(13, layer4DTO.getNpc2_객체속도());
                ps.setString(14, layer4DTO.getNpc2_객체가감속도());
                ps.setString(15, layer4DTO.getNpc2_Trigger_가감속());
                ps.setString(16, layer4DTO.getNpc2_객체행동_시작());
                ps.setString(17, layer4DTO.getNpc2_객체행동_동작());
                ps.setString(18, layer4DTO.getNpc2_Trigger_동작());

                ps.setString(19, layer4DTO.getNpc3_객체종류());
                ps.setString(20, layer4DTO.getNpc3_객체위치_차로());
                ps.setString(21, layer4DTO.getNpc3_객체위치_상대거리());
                ps.setString(22, layer4DTO.getNpc3_객체속도());
                ps.setString(23, layer4DTO.getNpc3_객체가감속도());
                ps.setString(24, layer4DTO.getNpc3_Trigger_가감속());
                ps.setString(25, layer4DTO.getNpc3_객체행동_시작());
                ps.setString(26, layer4DTO.getNpc3_객체행동_동작());
                ps.setString(27, layer4DTO.getNpc3_Trigger_동작());

                ps.setString(28, layer4DTO.getNpc4_객체종류());
                ps.setString(29, layer4DTO.getNpc4_객체위치_차로());
                ps.setString(30, layer4DTO.getNpc4_객체위치_상대거리());
                ps.setString(31, layer4DTO.getNpc4_객체속도());
                ps.setString(32, layer4DTO.getNpc4_객체가감속도());
                ps.setString(33, layer4DTO.getNpc4_Trigger_가감속());
                ps.setString(34, layer4DTO.getNpc4_객체행동_시작());
                ps.setString(35, layer4DTO.getNpc4_객체행동_동작());
                ps.setString(36, layer4DTO.getNpc4_Trigger_동작());

                ps.setString(37, layer4DTO.get객체종류());
                ps.setString(38, layer4DTO.get객체위치_차로());
                ps.setString(39, layer4DTO.get객체속도());
                ps.setString(40, layer4DTO.get객체행동_시작());
                ps.setString(41, layer4DTO.get객체예상행동_동작());

            }
            public int getBatchSize() {
                return layer4DTOS.size();
            }
        });
    }

    public int[] insertLayer5(final List<Layer5DTO> layer5DTOs) {
        String sql = "insert into Layer5 (시간대, 요일, 날씨, 기온, 조도) values (?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer5DTO layer5DTO = layer5DTOs.get(i);
                ps.setString(1, layer5DTO.get시간대());
                ps.setString(2, layer5DTO.get요일());
                ps.setString(3, layer5DTO.get날씨());
                ps.setString(4, layer5DTO.get기온());
                ps.setString(5, layer5DTO.get조도());
            }
            public int getBatchSize() {
                return layer5DTOs.size();
            }
        });
    }

    public int[] insertLayer6(final List<Layer6DTO> layer6DTOs) {
        String sql = "insert into Layer6 (Camera센서, Rader센서, LiDAR센서, V2I, V2V, V2P, V2N, V2C, GPS정보, 전자지도정보) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer6DTO layer6DTO = layer6DTOs.get(i);
                ps.setString(1, layer6DTO.getCamera센서());
                ps.setString(2, layer6DTO.getRader센서());
                ps.setString(3, layer6DTO.getLiDAR센서());
                ps.setString(4, layer6DTO.getV2I());
                ps.setString(5, layer6DTO.getV2V());
                ps.setString(6, layer6DTO.getV2P());
                ps.setString(7, layer6DTO.getV2N());
                ps.setString(8, layer6DTO.getV2C());
                ps.setString(9, layer6DTO.getGPS정보());
                ps.setString(10, layer6DTO.get전자지도정보());
            }
            public int getBatchSize() {
                return layer6DTOs.size();
            }
        });
    }

    public int[] insertLayer7(final List<Layer7DTO> layer7DTOs) {
        String sql = "insert into Layer7 (법_규제) values (?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer7DTO layer7DTO = layer7DTOs.get(i);
                ps.setString(1, layer7DTO.get법ㆍ규제());
            }

            public int getBatchSize() {
                return layer7DTOs.size();
            }
        });
    }

    public int[] insertScenario(int scenarioSize){
        String sql = "insert into Scenario (layer1, layer2, layer3, layer4, layer5, layer6, layer7) values (?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, i+1);
                ps.setLong(2, i+1);
                ps.setLong(3, i+1);
                ps.setLong(4, i+1);
                ps.setLong(5, i+1);
                ps.setLong(6, i+1);
                ps.setLong(7, i+1);

            }

            public int getBatchSize() {
                return scenarioSize;
            }
        });
    }
}
