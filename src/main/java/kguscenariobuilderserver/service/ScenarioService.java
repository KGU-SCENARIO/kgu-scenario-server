package kguscenariobuilderserver.service;

import kguscenariobuilderserver.dto.InsertScenario;
import kguscenariobuilderserver.dto.SaveScenariosResult;
import kguscenariobuilderserver.dto.ScenarioDto;
import kguscenariobuilderserver.entity.Scenario;
import kguscenariobuilderserver.repository.ScenarioDao;
import kguscenariobuilderserver.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioDao scenarioDao;
    private final ScenarioRepository scenarioRepository;

    public SaveScenariosResult saveScenarios(InsertScenario insertScenario){
        scenarioDao.insertLayer1(insertScenario.getLayer1DTOs());
        scenarioDao.insertLayer2(insertScenario.getLayer2DTOs());
        scenarioDao.insertLayer3(insertScenario.getLayer3DTOs());
        scenarioDao.insertLayer4(insertScenario.getLayer4DTOs());
        scenarioDao.insertLayer5(insertScenario.getLayer5DTOs());
        scenarioDao.insertLayer6(insertScenario.getLayer6DTOs());
        scenarioDao.insertLayer7(insertScenario.getLayer7DTOs());

        return new SaveScenariosResult(insertScenario);
    }

    public List<ScenarioDto> readScenarioDtos(){
        return scenarioRepository.findAllToDto();
    }

    public List<Scenario> readScenarios(){
        return scenarioRepository.findAll();
    }


}
