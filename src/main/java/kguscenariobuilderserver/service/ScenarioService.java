package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.SaveScenariosResult;
import kguscenariobuilderserver.dto.ScenarioDTO;
import kguscenariobuilderserver.entity.Scenario;
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

    public SaveScenariosResult saveScenarios(InsertScenario insertScenario){

        int scenarioSize = validateScenarioSize(insertScenario);
        scenarioDAO.insertLayer1(insertScenario.getLayer1DTOs());
        scenarioDAO.insertLayer2(insertScenario.getLayer2DTOs());
        scenarioDAO.insertLayer3(insertScenario.getLayer3DTOs());
        scenarioDAO.insertLayer4(insertScenario.getLayer4DTOs());
        scenarioDAO.insertLayer5(insertScenario.getLayer5DTOs());
        scenarioDAO.insertLayer6(insertScenario.getLayer6DTOs());
        scenarioDAO.insertLayer7(insertScenario.getLayer7DTOs());
        scenarioDAO.insertScenario(scenarioSize);

        return new SaveScenariosResult(insertScenario);
    }

    public List<ScenarioDTO> readScenarioDTOs(){
        return scenarioRepository.findAllToDTO();
    }

    public List<Scenario> readScenarios(){
        return scenarioRepository.findAll();
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
