package kguscenariobuilderserver.config;

import kguscenariobuilderserver.interceptor.LoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingInterceptor);
    }
}
