package kguscenariobuilderserver.repository;

import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Long> {

    @Query("select new kguscenariobuilderserver.dto.ScenarioDTO(s) " +
            "from Scenario s " +
            "join fetch s.layer1 " +
            "join fetch s.layer2 " +
            "join fetch s.layer3 " +
            "join fetch s.layer4 " +
            "join fetch s.layer5 " +
            "join fetch s.layer6 " +
            "join fetch s.layer7 "
    )
    List<ScenarioDTO> findAllToDTO();
}
