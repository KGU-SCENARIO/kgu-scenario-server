package kguscenariobuilderserver.exception.custom;

import static kguscenariobuilderserver.exception.GlobalExceptionCode.SCENARIO_COUNT_MISMATCH;

public class ScenarioCountMismatchException extends CustomException{
    public ScenarioCountMismatchException() {
        super(SCENARIO_COUNT_MISMATCH);
    }
}
