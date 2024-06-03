package kguscenariobuilderserver.scenario;

import com.example.kguscenarioserver.entity.Scenario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestScenario {
    private String result;

    public static Scenario convertToScenario(RequestScenario dto) {
        Scenario scenario = new Scenario(dto.getResult());
        return scenario;
    }
}
