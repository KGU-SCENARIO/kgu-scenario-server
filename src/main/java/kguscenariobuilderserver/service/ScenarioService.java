package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.exception.InsertScenarioException;
import kguscenariobuilderserver.repository.ScenarioDAO;
import kguscenariobuilderserver.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioDAO scenarioDAO;
    private final ScenarioRepository scenarioRepository;
    public String saveScenarios(InsertScenario insertScenario){
        int scenarioSize = validateScenarioSize(insertScenario);
        Long maxId = scenarioDAO.maxId();
        scenarioDAO.insertLayer1(insertScenario.getLayer1DTOs(), maxId);
        scenarioDAO.insertLayer2(insertScenario.getLayer2DTOs(), maxId);
        scenarioDAO.insertLayer3(insertScenario.getLayer3DTOs(), maxId);
        scenarioDAO.insertLayer4(insertScenario.getLayer4DTOs(), maxId);
        scenarioDAO.insertLayer5(insertScenario.getLayer5DTOs(), maxId);
        scenarioDAO.insertLayer6(insertScenario.getLayer6DTOs(), maxId);
        scenarioDAO.insertLayer7(insertScenario.getLayer7DTOs(), maxId);
        scenarioDAO.insertScenario(scenarioSize, maxId);

        return scenarioSize + "개 시나리오 저장 성공 !";
    }

    public List<ScenarioDTO> readScenarioDTOs(){
        return scenarioRepository.findAllToDTO();
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
