
package org.springbootdev.common.launch;

import org.springbootdev.common.constant.CommonConstant;
import org.springbootdev.core.launch.service.LauncherService;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * 启动参数拓展
 *
 * @author smallchil
 */
public class LauncherServiceImpl implements LauncherService {

	@Override
	public void launcher(SpringApplicationBuilder builder, String appName, String profile) {
		Properties props = System.getProperties();
		props.setProperty("spring.cloud.sentinel.transport.dashboard", CommonConstant.sentinelAddr(profile));
	}

}
