package org.springbootexample.jwt.api;

import org.springbootexample.jwt.api.model.BaseResponse;
import org.springbootexample.jwt.api.model.LoginParam;
import org.springbootexample.jwt.common.util.JWTUtil;
import org.springbootexample.jwt.model.ManagerInfo;
import org.springbootexample.jwt.service.ManagerInfoService;
import org.springbootexample.jwt.shiro.ShiroKit;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录接口类
 */
@RestController
public class LoginController {

    @Resource
    private ManagerInfoService managerInfoService;

    private static final Logger _logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public BaseResponse<String> login(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType,
                                      @RequestBody LoginParam loginParam) {
        _logger.info("用户请求登录获取Token");
        String username = loginParam.getUsername();
        String password = loginParam.getPassword();
        ManagerInfo user = managerInfoService.findByUsername(username);
        //随机数盐
        String salt = user.getSalt();
        //原密码加密（通过username + salt作为盐）
        String encodedPassword = ShiroKit.md5(password, username + salt);
        if (user.getPassword().equals(encodedPassword)) {
            return new BaseResponse<>(true, "Login success", JWTUtil.sign(username, encodedPassword));
        } else {
            throw new UnauthorizedException();
        }
    }

}
