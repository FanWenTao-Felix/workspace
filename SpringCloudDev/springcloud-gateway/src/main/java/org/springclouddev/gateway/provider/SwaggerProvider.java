

package org.springclouddev.gateway.provider;

import lombok.AllArgsConstructor;
import org.springclouddev.gateway.props.RouteProperties;
import org.springclouddev.gateway.props.RouteResource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * 聚合接口文档注册
 *
 * @author zhaobohao
 */
@Primary
@Component
@AllArgsConstructor
public class SwaggerProvider implements SwaggerResourcesProvider {
	private static final String API_URI = "/v2/api-docs-ext";

	private RouteProperties routeProperties;

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resources = new ArrayList<>();
		List<RouteResource> routeResources = routeProperties.getResources();
		routeResources.forEach(routeResource -> resources.add(swaggerResource(routeResource)));
		return resources;
	}

	private SwaggerResource swaggerResource(RouteResource routeResource) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(routeResource.getName());
		swaggerResource.setLocation(routeResource.getLocation().concat(API_URI));
		swaggerResource.setSwaggerVersion(routeResource.getVersion());
		return swaggerResource;
	}

}
