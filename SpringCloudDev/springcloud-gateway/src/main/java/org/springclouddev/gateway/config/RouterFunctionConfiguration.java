package org.springclouddev.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springclouddev.gateway.handler.SwaggerResourceHandler;
import org.springclouddev.gateway.handler.SwaggerSecurityHandler;
import org.springclouddev.gateway.handler.SwaggerUiHandler;
import org.springclouddev.gateway.props.AuthProperties;
import org.springclouddev.gateway.props.RouteProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 路由配置信息
 *
 * @author zhaobohao
 */
@Slf4j
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties({RouteProperties.class, AuthProperties.class})
public class RouterFunctionConfiguration {

    private final SwaggerResourceHandler swaggerResourceHandler;
    private final SwaggerSecurityHandler swaggerSecurityHandler;
    private final SwaggerUiHandler swaggerUiHandler;

    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions.route(RequestPredicates.GET("/swagger-resources")
                .and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }

}