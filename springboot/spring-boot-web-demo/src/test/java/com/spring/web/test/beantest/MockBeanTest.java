package com.spring.web.test.beantest;

import com.spring.web.test.BaseTest;
import com.spring.web.test.bean.HelloService;
import com.spring.web.test.bean.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


/**
 * 测试bean结果的mock
 */
@Slf4j
public class MockBeanTest extends BaseTest {

    //这里只是让spring去mock helloService,但没有注入？？
    @MockBean
    //这里是把spring 已经mock好的bean,拿出来用，真是见鬼了。看来这两个注解要合起来用了。
    @Resource
    private HelloService helloService;

    @Test
    public void exampleTest() {
        //这句的意思是当调用helloService的getRemoteVal方法时，返回mock的结果："远程调用结果"
        given(this.helloService.getRemoteVal()).willReturn("远程调用结果");
        //when(this.helloService.getRemoteVal()).
        //进行调用测试
        String reverse = helloService.getRemoteVal();
        assertThat(reverse).isEqualTo("远程调用结果");
    }

    @Test
    public void implTest()
    {
        //这句的意思是当调用helloService的getRemoteVal方法时，返回mock的结果："远程调用结果"
        given(this.helloService.getRemoteVal()).willReturn("remote Val");
        log.info(helloService.getRemoteVal());
        assertThat(helloService.getRemoteVal()).isEqualTo("remote Val");
    }

}
