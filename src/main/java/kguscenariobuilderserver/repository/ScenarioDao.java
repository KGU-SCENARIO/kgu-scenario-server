package kguscenariobuilderserver.repository;

import kguscenariobuilderserver.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScenarioDao {
    private final JdbcTemplate jdbcTemplate;

    private int[] batchInsert(String sql, BatchPreparedStatementSetter pss) {
        return this.jdbcTemplate.batchUpdate(sql, pss);
    }

    public int[] insertLayer1(final List<Layer1Dto> layer1Dtos) {
        String sql = "insert into Layer1 (도로_기능과_등급, 차로폭, 갓길폭, 도로선형, 도로경사, 차로수, 도로포장, 노면상태, 도로유형) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer1Dto layer1Dto = layer1Dtos.get(i);
                ps.setString(1, layer1Dto.get도로_기능과_등급());
                ps.setString(2, layer1Dto.get차로폭());
                ps.setString(3, layer1Dto.get갓길폭());
                ps.setString(4, layer1Dto.get도로선형());
                ps.setString(5, layer1Dto.get도로경사());
                ps.setString(6, layer1Dto.get차로수());
                ps.setString(7, layer1Dto.get도로포장());
                ps.setString(8, layer1Dto.get노면상태());
                ps.setString(9, layer1Dto.get도로유형());
            }
            public int getBatchSize() {
                return layer1Dtos.size();
            }
        });
    }

    public int[] insertLayer2(final List<Layer2Dto> layer2Dtos) {
        String sql = "insert into Layer2 (중앙분리대, 방호울타리, 충격흡수시설, 연속조명, 국부조명, 과속방지턱, 차량신호, 도로상태예고, 노면상황예고, 기타주의예고, 통행금지, 통행제한, 금지사항, 도로지정, 통행방법, 중앙선, 차선, 사전예고표시, 안전속도표시, 금지구역표시, 최고제한속도, 최저제한속도, 보호구역, 전용도로) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer2Dto layer2Dto = layer2Dtos.get(i);
                ps.setString(1, layer2Dto.get중앙분리대());
                ps.setString(2, layer2Dto.get방호울타리());
                ps.setString(3, layer2Dto.get충격흡수시설());
                ps.setString(4, layer2Dto.get연속조명());
                ps.setString(5, layer2Dto.get국부조명());
                ps.setString(6, layer2Dto.get과속방지턱());
                ps.setString(7, layer2Dto.get차량신호());
                ps.setString(8, layer2Dto.get도로상태예고());
                ps.setString(9, layer2Dto.get노면상황예고());
                ps.setString(10, layer2Dto.get기타주의예고());
                ps.setString(11, layer2Dto.get통행금지());
                ps.setString(12, layer2Dto.get통행제한());
                ps.setString(13, layer2Dto.get금지사항());
                ps.setString(14, layer2Dto.get도로지정());
                ps.setString(15, layer2Dto.get통행방법());
                ps.setString(16, layer2Dto.get중앙선());
                ps.setString(17, layer2Dto.get차선());
                ps.setString(18, layer2Dto.get사전예고표시());
                ps.setString(19, layer2Dto.get안전속도표시());
                ps.setString(20, layer2Dto.get금지구역표시());
                ps.setString(21, layer2Dto.get최고제한속도());
                ps.setString(22, layer2Dto.get최저제한속도());
                ps.setString(23, layer2Dto.get보호구역());
                ps.setString(24, layer2Dto.get전용도로());
            }
            public int getBatchSize() {
                return layer2Dtos.size();
            }
        });
    }

    public int[] insertLayer3(final List<Layer3Dto> layer3Dtos) {
        String sql = "insert into Layer3 (도로공사, 선행사고, 장애물) values (?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer3Dto layer3Dto = layer3Dtos.get(i);
                ps.setString(1, layer3Dto.get도로공사());
                ps.setString(2, layer3Dto.get선행사고());
                ps.setString(3, layer3Dto.get장애물());
            }
            public int getBatchSize() {
                return layer3Dtos.size();
            }
        });
    }

    public int[] insertLayer5(final List<Layer5Dto> layer5Dtos) {
        String sql = "insert into Layer5 (시간대, 요일, 날씨, 기온, 조도) values (?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer5Dto layer5Dto = layer5Dtos.get(i);
                ps.setString(1, layer5Dto.get시간대());
                ps.setString(2, layer5Dto.get요일());
                ps.setString(3, layer5Dto.get날씨());
                ps.setString(4, layer5Dto.get기온());
                ps.setString(5, layer5Dto.get조도());
            }
            public int getBatchSize() {
                return layer5Dtos.size();
            }
        });
    }

    public int[] insertLayer6(final List<Layer6Dto> layer6Dtos) {
        String sql = "insert into Layer6 (Camera센서, Rader센서, LiDAR센서, V2I, V2V, V2P, V2N, V2C, GPS정보, 전자지도정보) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer6Dto layer6Dto = layer6Dtos.get(i);
                ps.setString(1, layer6Dto.getCamera센서());
                ps.setString(2, layer6Dto.getRader센서());
                ps.setString(3, layer6Dto.getLiDAR센서());
                ps.setString(4, layer6Dto.getV2I());
                ps.setString(5, layer6Dto.getV2V());
                ps.setString(6, layer6Dto.getV2P());
                ps.setString(7, layer6Dto.getV2N());
                ps.setString(8, layer6Dto.getV2C());
                ps.setString(9, layer6Dto.getGPS정보());
                ps.setString(10, layer6Dto.get전자지도정보());
            }
            public int getBatchSize() {
                return layer6Dtos.size();
            }
        });
    }

    public int[] insertLayer7(final List<Layer7Dto> layer7Dtos) {
        String sql = "insert into Layer7 (법_규제) values (?)";
        return batchInsert(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Layer7Dto layer7Dto = layer7Dtos.get(i);
                ps.setString(1, layer7Dto.get법ㆍ규제());
            }

            public int getBatchSize() {
                return layer7Dtos.size();
            }
        });
    }

    public int[] scenarioInsert(int scenarioSize){
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
