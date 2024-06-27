package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.entity.layer.Layer3;
import kguscenariobuilderserver.exception.InsertScenarioException;
import kguscenariobuilderserver.repository.ScenarioDAO;
import kguscenariobuilderserver.repository.ScenarioRepository;
import kguscenariobuilderserver.repository.layer.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;


@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioDAO scenarioDAO;

    private final ScenarioRepository scenarioRepository;
    private final Layer1Repository layer1Repository;
    private final Layer2Repository layer2Repository;
    private final Layer3Repository layer3Repository;
    private final Layer4Repository layer4Repository;
    private final Layer5Repository layer5Repository;
    private final Layer6Repository layer6Repository;
    private final Layer7Repository layer7Repository;


    @Value("${page.size}") private int PAGE_SIZE;

    @Transactional
    public String saveScenarios(InsertScenario insertScenario){
        validateScenarioSize(insertScenario);
        int size = scenarioDAO.batchInsertScenarios(insertScenario);
        return size + "개 시나리오 저장 성공 !";
    }

    @Transactional(readOnly = true)
    public Page<ScenarioDTO> readScenarioDTOs(int pageNo){
        Pageable pageable = PageRequest.of(pageNo,PAGE_SIZE);
        return scenarioRepository.findAllToDTO(pageable);
    }

    @Transactional
    public String deleteScenarios(){

        scenarioRepository.deleteAllInBatch();
        layer1Repository.deleteAllInBatch();
        layer2Repository.deleteAllInBatch();
        layer3Repository.deleteAllInBatch();
        layer4Repository.deleteAllInBatch();
        layer5Repository.deleteAllInBatch();
        layer6Repository.deleteAllInBatch();
        layer7Repository.deleteAllInBatch();

        return "삭제 완료";
    }

    public void validateScenarioSize(InsertScenario insertScenario) {
        int size = insertScenario.getLayer1DTOs().size();

        if (size != insertScenario.getLayer2DTOs().size() ||
                size != insertScenario.getLayer3DTOs().size() ||
                size != insertScenario.getLayer4DTOs().size() ||
                size != insertScenario.getLayer5DTOs().size() ||
                size != insertScenario.getLayer6DTOs().size() ||
                size != insertScenario.getLayer7DTOs().size()) {
            throw new InsertScenarioException("각 레이어의 크기가 일치하지 않습니다.");
        }
    }

}
