package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.dto.ScenarioRequest;
import kguscenariobuilderserver.exception.custom.ScenarioCountMismatchException;
import kguscenariobuilderserver.repository.ScenarioDAO;
import kguscenariobuilderserver.repository.ScenarioRepository;
import kguscenariobuilderserver.repository.layer.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
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
    public String saveScenarios(ScenarioRequest scenarioRequest){
        validateScenarioSize(scenarioRequest);
        int size = scenarioDAO.batchInsertScenarios(scenarioRequest);
        return size + "개 시나리오 저장 성공 !";
    }

    @Transactional(readOnly = true)
    public Page<ScenarioDTO> readScenarioDTOs(int pageNo){
        Pageable pageable = PageRequest.of(pageNo,PAGE_SIZE);
        return scenarioRepository.findAllToDTO(pageable);
    }

    @Transactional
    public void deleteScenarios(){
        scenarioRepository.deleteAllInBatch();
        layer1Repository.deleteAllInBatch();
        layer2Repository.deleteAllInBatch();
        layer3Repository.deleteAllInBatch();
        layer4Repository.deleteAllInBatch();
        layer5Repository.deleteAllInBatch();
        layer6Repository.deleteAllInBatch();
        layer7Repository.deleteAllInBatch();
    }

    public void validateScenarioSize(ScenarioRequest scenarioRequest) {
        int size = scenarioRequest.layer1DTOs().size();

        boolean result = size != scenarioRequest.layer2DTOs().size() ||
            size != scenarioRequest.layer3DTOs().size() ||
            size != scenarioRequest.layer4DTOs().size() ||
            size != scenarioRequest.layer5DTOs().size() ||
            size != scenarioRequest.layer6DTOs().size() ||
            size != scenarioRequest.layer7DTOs().size();

        if (result) {
            throw new ScenarioCountMismatchException();
        }
    }

}
