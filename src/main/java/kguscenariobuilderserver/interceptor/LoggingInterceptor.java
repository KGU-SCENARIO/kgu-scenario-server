package kguscenariobuilderserver.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import kguscenariobuilderserver.logging.LoggingUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

		@Override
		public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response,
														 @NotNull Object handler) {
				request.setAttribute("startTime", System.currentTimeMillis());
				return true;
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
																Exception ex) {
				LoggingUtils.logDuration(request, response, ex);
		}

}
