package kguscenariobuilderserver.exception;

import kguscenariobuilderserver.exception.custom.CustomException;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ExceptionResponse(
		HttpStatus status,
		String code,
		String message
) {
		public static ExceptionResponse from(CustomException exception){
				return ExceptionResponse.builder()
						.status(exception.getCode().getStatus())
						.code(exception.getCode().getCode())
						.message(exception.getMessage())
						.build();
		}

		public static ExceptionResponse of(HttpStatus status, String code, String message){
				return ExceptionResponse.builder()
						.status(status)
						.code(code)
						.message(message)
						.build();
		}
}
