package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.dto.scenario.ScenarioDto;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService {
    private final ScenarioRepository scenarioRepository;

    /*
    시나리오 저장
    */
    @Transactional
    public void saveScenario(Scenario scenario){
        scenarioRepository.save(scenario);
    }

    @Transactional
    public void saveScenarios(List<Scenario> scenarios){
        scenarioRepository.saveAll(scenarios);
    }

    /*
    시나리오 조회
    */
    public List<Scenario> scenarioList(){
        return scenarioRepository.findAll();
    }

    /*
    해당 시나리오 삭제
    */
    @Transactional
    public void deleteScenario(Long id){
        scenarioRepository.deleteById(id);
    }

    /*
    모든 시나리오 삭제
    */
    @Transactional
    public void deleteAllScenario(){
        scenarioRepository.deleteAll();
    }
}
