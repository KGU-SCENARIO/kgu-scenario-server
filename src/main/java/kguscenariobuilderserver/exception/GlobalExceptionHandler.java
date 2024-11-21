package kguscenariobuilderserver.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import kguscenariobuilderserver.exception.custom.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static kguscenariobuilderserver.exception.GlobalExceptionCode.INVALID_INPUT;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
		private final ApplicationEventPublisher eventPublisher;

		@ExceptionHandler(CustomException.class)
		protected ResponseEntity<ExceptionResponse> handleCustomException(CustomException exception){
				if (exception.isServerError())
						eventPublisher.publishEvent(exception);
				ExceptionResponse response = ExceptionResponse.from(exception);
				return ResponseEntity.status(response.status()).body(response);
		}

		@Override
		protected ResponseEntity<Object> handleTypeMismatch(
				TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

				Object[] args = {ex.getPropertyName(), ex.getValue()};
				String defaultDetail = "Failed to convert '" + args[0] + "' with value: '" + args[1] + "'";

				ExceptionResponse response = ExceptionResponse.of(INVALID_INPUT.getStatus(), INVALID_INPUT.getCode(), defaultDetail);
				return ResponseEntity.status(response.status()).body(response);
		}

		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

				List<String> errorDetails = ex.getBindingResult().getFieldErrors().stream()
						.map(fieldError -> String.format(
								"필드 '%s': 값 '%s' - %s",
								fieldError.getField(),
								fieldError.getRejectedValue(),
								fieldError.getDefaultMessage()
						))
						.collect(Collectors.toList());

				// 상세 메시지 구성
				String detailedMessage = String.join("; ", errorDetails);

				ExceptionResponse response = ExceptionResponse.of(INVALID_INPUT.getStatus(), INVALID_INPUT.getCode(), detailedMessage);
				return ResponseEntity.status(response.status()).body(response);
		}


		@Override
		protected ResponseEntity<Object> handleHttpMessageNotReadable(
				HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

				Throwable rootCause = ex.getRootCause();
				String detailMessage = "요청 본문을 읽을 수 없습니다.";

				if (rootCause instanceof InvalidFormatException invalidFormatEx) {
						String fieldName = invalidFormatEx.getPath().stream()
								.map(ref -> ref.getFieldName())
								.findFirst()
								.orElse("Unknown field");

						Object invalidValue = invalidFormatEx.getValue();
						String targetType = invalidFormatEx.getTargetType().getSimpleName();

						detailMessage = String.format("필드 '%s'의 값 '%s'는 유효하지 않습니다. 기대하는 타입: %s",
								fieldName, invalidValue, targetType);
				}

				ExceptionResponse response = ExceptionResponse.of(INVALID_INPUT.getStatus(), INVALID_INPUT.getCode(), detailMessage);
				return ResponseEntity.status(response.status()).body(response);
		}
}
