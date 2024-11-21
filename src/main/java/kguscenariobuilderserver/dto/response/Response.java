package kguscenariobuilderserver.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Response {
    private boolean success;
    private int code;
    private Result result;

    public static <T> Response success(T data, int code){
        return new Response(true, code, new Success<>(data));
    }

}
