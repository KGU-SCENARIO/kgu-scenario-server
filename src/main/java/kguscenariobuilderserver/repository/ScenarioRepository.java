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
            "from Scenario s")
    List<ScenarioDTO> findAllToDTO();
}
