package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.exception.InsertScenarioException;
import kguscenariobuilderserver.repository.ScenarioDAO;
import kguscenariobuilderserver.repository.ScenarioRepository;
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

    @Value("${page.size}") private int PAGE_SIZE;

    @Transactional
    public String saveScenarios(InsertScenario insertScenario){
        int scenarioSize = validateScenarioSize(insertScenario);
        scenarioDAO.batchInsertScenarios(scenarioSize, insertScenario);
        return scenarioSize + "개 시나리오 저장 성공 !";
    }

    @Transactional(readOnly = true)
    public Page<ScenarioDTO> readScenarioDTOs(int pageNo){
        Pageable pageable = PageRequest.of(pageNo,PAGE_SIZE);
        return scenarioRepository.findAllToDTO(pageable);
    }

    public int validateScenarioSize(InsertScenario insertScenario) {
        int size = insertScenario.getLayer1DTOs().size();

        if (!(size != insertScenario.getLayer2DTOs().size() ||
                size != insertScenario.getLayer3DTOs().size() ||
                size != insertScenario.getLayer4DTOs().size() ||
                size != insertScenario.getLayer5DTOs().size() ||
                size != insertScenario.getLayer6DTOs().size() ||
                size != insertScenario.getLayer7DTOs().size())) return size;
        else {
            throw new InsertScenarioException("각 레이어의 크기가 일치하지 않습니다.");
        }
    }
}
