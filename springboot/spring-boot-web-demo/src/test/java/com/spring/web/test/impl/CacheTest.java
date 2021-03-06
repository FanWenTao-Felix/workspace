package com.spring.web.test.impl;

import com.spring.web.test.BaseTest;
import com.spring.web.test.bean.HelloService;
import com.spring.web.test.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class CacheTest  extends BaseTest {
    @Resource
   CacheService cacheService;
    @Resource
    private HelloService helloServiceImpl;
    @Test
    public void novoid()
    {
        log.info("test spring cache annotion ");
        for (int i = 0; i < 10; i++) {
            log.info(cacheService.getName());
            log.info(cacheService.getNameWithoutCache());
        }

    }

    @Test
    public void implTest()
    {
        log.info(helloServiceImpl.getRemoteVal());
        assertThat(helloServiceImpl.getRemoteVal()).isEqualTo("remote Val");
    }

}
