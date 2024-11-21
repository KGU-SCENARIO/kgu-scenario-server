package kguscenariobuilderserver.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
public enum GlobalExceptionCode implements ExceptionCode {
		INVALID_INPUT(BAD_REQUEST, "유효한 입력 형식이 아닙니다."),
		SERVER_ERROR(INTERNAL_SERVER_ERROR, "예상치 못한 문제가 발생했습니다."),
		SCENARIO_COUNT_MISMATCH(BAD_REQUEST, "각 레이어의 시나리오 개수가 일치하지 않습니다.");

		private final HttpStatus status;
		private final String message;

		@Override
		public String getCode() {
				return this.name();
		}
}
