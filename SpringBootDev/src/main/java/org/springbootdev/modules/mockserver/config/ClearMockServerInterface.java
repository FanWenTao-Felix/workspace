package org.springbootdev.modules.mockserver.config;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.ClearType;
import org.springbootdev.modules.mockserver.entity.MockHttp;
import org.springbootdev.modules.mockserver.service.IMockHttpService;
import org.springbootdev.modules.mockserver.wrapper.MockWrapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhaobo
 *
 * 消息监听者
 **/
@Component
@Slf4j
public class ClearMockServerInterface {
	@Resource
	private IMockHttpService mockHttpService;
	@Resource
	private MockServerInit  mockServerInit;

	public void receiveMessage(String mockHttpID) {
		log.info("clearmockserver change message：{}", mockHttpID);

		if(StrUtil.isBlank(mockHttpID))
		{
			log.error("receive bad message .message is {}",mockHttpID);
			return;
		}
		ClientAndServer mockClient = GlobalMockServerClient.INSTANCE.getInstance();
		//收到mockserver接口变动的消息后，开始处理接口变动信息
//清理之前的mock接口
		MockHttp mockHttp=this.mockHttpService.getById(mockHttpID);
		mockClient.clear(MockWrapper.mockRequest(mockHttp).get(), ClearType.ALL);
		log.info(" clearmockserver {} completed!",mockHttpID);
	}
}
