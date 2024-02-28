package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.dto.scenario.ScenarioRequest;
import com.example.kguscenarioserver.dto.scenario.ScenarioResponse;
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
        validateScenario(scenario);
        scenarioRepository.save(scenario);
    }

    /*
    시나리오 중복 확인
    */
    public void validateScenario(Scenario scenario){
        List<Scenario> findScenarios = scenarioRepository.findByResult(scenario.getResult());
        if (!findScenarios.isEmpty()){
            throw new IllegalStateException("이미 존재하는 시나리오입니다.");
        }
    }

    /*
    시나리오 조회
    */
    public List<Scenario> scenarioList(){
        return scenarioRepository.findAll();
    }

}
