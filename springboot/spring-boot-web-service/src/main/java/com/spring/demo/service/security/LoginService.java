

package com.spring.demo.service.security;

import com.spring.demo.param.LoginParam;
import com.spring.web.core.api.ApiResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  登录服务接口
 * </p>
 * @auth geekidea
 * @date 2019-05-23
 **/
public interface LoginService {

    ApiResult login(LoginParam loginParam);

    void refreshToken(HttpServletResponse response, Jws<Claims> jws);

}
