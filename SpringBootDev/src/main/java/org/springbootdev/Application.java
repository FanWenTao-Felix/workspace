
package org.springbootdev;

import org.springbootdev.common.constant.CommonConstant;
import org.springbootdev.core.launch.SpingCloudDevApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 启动器
 *
 * @author merryChen
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	public static void main(String[] args) {
		SpingCloudDevApplication.run(CommonConstant.APPLICATION_NAME, Application.class, args);
	}

}

