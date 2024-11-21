package kguscenariobuilderserver.logging;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class LoggingUtils {

		public static List<String> getArguments(JoinPoint joinPoint) {
				return Arrays.stream(joinPoint.getArgs())
						.map(LoggingUtils::getObjectFields)
						.toList();
		}

		public static String getObjectFields(Object obj) {
				StringBuilder result = new StringBuilder();
				Class<?> objClass = obj.getClass();
				result.append(objClass.getSimpleName()).append(" {");

				Field[] fields = objClass.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
						fields[i].setAccessible(true);
						try {
								result.append(fields[i].getName()).append(" = ")
										.append(fields[i].get(obj));
						} catch (IllegalAccessException e) {
								result.append(fields[i].getName()).append("=ACCESS_DENIED");
						}
						if (i < fields.length - 1) {
								result.append(", ");
						}
				}
				result.append("}");
				return result.toString();
		}

		public static String getParameterMessage(List<String> arguments) {
				if (arguments == null)
						return "";

				return String.join(" | ", arguments);
		}

		public static void logDuration(HttpServletRequest request, HttpServletResponse response, Exception ex) {
				String requestUrl = request.getRequestURI();
				String httpMethod = request.getMethod();
				int httpStatus = response.getStatus();

				long startTime = (Long)request.getAttribute("startTime");
				long endTime = System.currentTimeMillis();
				long duration = endTime - startTime;

				if (ex == null) {
						log.info("[DURATION] ENDPOINT : {} {} || STATUS : {} || DURATION : {}ms", httpMethod, requestUrl,
								httpStatus, duration);
				} else {
						log.error("[DURATION] ENDPOINT : {} {} || STATUS : {} || DURATION : {}ms || EXCEPTION : {}",
								httpMethod, requestUrl, httpStatus, duration, ex.getMessage());
				}
		}
}
