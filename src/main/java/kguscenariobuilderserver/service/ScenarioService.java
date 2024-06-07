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
        scenarioDao.insertLayer1(insertScenario.getLayer1Dtos());
        scenarioDao.insertLayer2(insertScenario.getLayer2Dtos());
        scenarioDao.insertLayer3(insertScenario.getLayer3Dtos());
        //scenarioDao.insertLayer4(insertScenario.getLayer4Dtos());
        scenarioDao.insertLayer5(insertScenario.getLayer5Dtos());
        scenarioDao.insertLayer6(insertScenario.getLayer6Dtos());
        scenarioDao.insertLayer7(insertScenario.getLayer7Dtos());

        return new SaveScenariosResult(insertScenario);
    }

    public List<ScenarioDto> readScenarioDtos(){
        return scenarioRepository.findAllToDto();
    }

    public List<Scenario> readScenarios(){
        return scenarioRepository.findAll();
    }


}
