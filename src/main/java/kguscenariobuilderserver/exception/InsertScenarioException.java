package kguscenariobuilderserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsertScenarioException extends RuntimeException{
    private String message;
    public InsertScenarioException(String message){
        super(message);
        this.message = message;
    }
}
