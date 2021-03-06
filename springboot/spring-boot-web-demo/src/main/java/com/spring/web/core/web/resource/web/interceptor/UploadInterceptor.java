

package com.spring.web.core.web.resource.web.interceptor;

import com.spring.web.config.SpringBootPlusProperties;
import com.spring.web.core.api.ApiResult;
import com.spring.web.core.util.HttpServletResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传拦截器
 * @author zhaobohao
 * @date 2019/8/22
 * @since 1.2.2-RELEASE
 */
@Slf4j
public class UploadInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SpringBootPlusProperties springBootPlusProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果访问的不是控制器,则跳出,继续执行下一个拦截器
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 访问路径
        String url = request.getRequestURI();
        // 访问全路径
        String fullUrl = request.getRequestURL().toString();
        if (!springBootPlusProperties.getInterceptorConfig().getUploadConfig().isEnabled()){
            log.error("上传功能已关闭，非法上传：{}",fullUrl);
            HttpServletResponseUtil.printJSON(response, ApiResult.fail("非法上传"));
            return false;
        }

        // 上传拦截器，业务处理代码
        log.info("UploadInterceptor...");
        // 访问token，如果需要，可以设置参数，进行鉴权
        String token = request.getParameter("token");

        log.info("url:{}",url);
        log.info("fullUrl:{}",fullUrl);
        log.info("token:{}",token);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 记录实际上传日志...
    }
}
