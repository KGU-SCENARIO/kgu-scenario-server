package com.example.kguscenarioserver.service;

import com.example.kguscenarioserver.dto.scenario.ResponseScenario;
import com.example.kguscenarioserver.entity.Scenario;
import com.example.kguscenarioserver.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public void saveScenarioList(List<Scenario> scenarios){
        scenarioRepository.saveAll(scenarios);
    }

    /*
    시나리오 조회
    */
    public Page<ResponseScenario> scenarioList(Pageable pageable){
        int page = pageable.getPageNumber() -1;
        int pageLimit = 4;
        Page<Scenario> scenarioPage = scenarioRepository.findAll(PageRequest.of(page,pageLimit, Sort.by(Sort.Direction.DESC,"id")));

        Page<ResponseScenario> responseScenarioPage = scenarioPage.map(
                scenario -> new ResponseScenario(scenario.getResult(),scenario.getCreatedAt())
        );

        return responseScenarioPage;
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
