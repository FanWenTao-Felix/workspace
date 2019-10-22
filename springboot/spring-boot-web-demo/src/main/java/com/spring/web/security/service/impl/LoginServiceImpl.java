

package com.spring.web.security.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.spring.web.param.LoginParam;
import com.spring.web.service.security.LoginService;
import com.spring.web.vo.ClientInfo;
import com.spring.web.vo.JwtTokenRedisVo;
import com.spring.web.vo.LoginSysUserRedisVo;
import com.spring.web.vo.LoginSysUserVo;
import com.spring.web.core.api.ApiResult;
import com.spring.web.core.constant.CommonConstant;
import com.spring.web.core.constant.CommonRedisKey;
import com.spring.web.core.util.HttpServletRequestUtil;
import com.spring.web.core.util.MapUtil;
import com.spring.web.security.util.JwtUtil;
import com.spring.web.util.ClientInfoUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  登录服务实现类
 * </p>
 * @author zhaobohao
 * @date 2019-05-23
 **/
@Api
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CacheChannel cacheChannel;


    @Override
    public ApiResult login(LoginParam loginParam) {
        log.info("loginParam = " + loginParam);

        // 数据库校验账号密码

        Long userId = 1L;
        String userName = "admin";

        LoginSysUserVo loginSysUserVo = new LoginSysUserVo();
        loginSysUserVo.setId(userId);
        loginSysUserVo.setUserName(userName);

        // token过期时间
        Date expireDate = DateUtil.offsetMinute(new Date(), 30);
        // 创建token
        String token = JwtUtil.create(expireDate,null,null);
        // token md5,方便使用
        String tokenMd5 = DigestUtil.md5Hex(token);
        // login redis处理
        loginRedis(userId, loginSysUserVo, expireDate, token, tokenMd5);
        // 响应数据
        Map<String,Object> map = MapUtil.builder()
                .put("token",token)
                .put("loginSysUser",loginSysUserVo)
                .build();

        return ApiResult.ok(map);
    }

    /**
     * jwt生成的token携带用户id和账号，uuid唯一标识，返回token
     * redis存储当前登录对象的详细信息 hash
     *   key: login.sys.user.token的md5值
     *   value : LoginSysUserRedisVo
     * redis hash
     *   key: login.sys.user.用户ID
     *   value: token md5值
     * @param userId
     * @param loginSysUserVo
     * @param expireDate
     * @param token
     * @param tokenMd5
     */
    private void loginRedis(Long userId, LoginSysUserVo loginSysUserVo, Date expireDate, String token, String tokenMd5) {
        String loginTokenRedisKey = CommonRedisKey.LOGIN_TOKEN;

        // 获取用户客户端信息
        HttpServletRequest request = HttpServletRequestUtil.getRequest();
        String userAgent = request.getHeader("User-Agent");
        ClientInfo clientInfo = ClientInfoUtil.get(userAgent);
        log.info("clientInfo = " + JSON.toJSONString(clientInfo,true));

        // jwt token对象
        JwtTokenRedisVo jwtTokenRedisVo = new JwtTokenRedisVo();
        jwtTokenRedisVo.setToken(token);
        jwtTokenRedisVo.setTokenMd5(tokenMd5);
        jwtTokenRedisVo.setCreateDate(new Date());
        jwtTokenRedisVo.setExpiredDate(expireDate);

        // loginUser redis缓存信息
        LoginSysUserRedisVo loginSysUserRedisVo = new LoginSysUserRedisVo();
        loginSysUserRedisVo.setClientInfo(clientInfo);              // 设置用户客户端信息
        loginSysUserRedisVo.setLoginSysUserVo(loginSysUserVo);      // 设置系统登录用户对象
        loginSysUserRedisVo.setJwtTokenRedisVo(jwtTokenRedisVo);    // 设置系统登录用户token对象

        // token hash cache
        cacheChannel.set(loginTokenRedisKey,tokenMd5,loginSysUserRedisVo);

        // user hash cache
        String loginUserRedisKey = String.format(CommonRedisKey.LOGIN_SYS_USER,userId);

        // 支持一个账号多次登录
        cacheChannel.set(loginUserRedisKey,tokenMd5,jwtTokenRedisVo);

        // 单个登录，始终以最后一个有效
//        String oneLoginUserRedisKey = "login:sys:user";
//        redisTemplate.opsForHash().put(oneLoginUserRedisKey,String.valueOf(userId),jwtTokenRedisVo);


    }


    /**
     * 刷新token
     * @param response
     * @param jws
     */
    @Override
    public void refreshToken(HttpServletResponse response, Jws<Claims> jws) {
        Date expiredDate = jws.getBody().getExpiration();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String string = dateFormat.format(expiredDate);
        log.info("expiredDate = " + string);

        // 如果token还有1分钟要过期，则重新生成token，并响应到response头中
        Date beforeExpiredDate = DateUtil.offsetMinute(expiredDate,-1);
        long beforeExpiredTime = beforeExpiredDate.getTime();

        Date currentDate = new Date(System.currentTimeMillis());
        long currentTime = currentDate.getTime();

        log.info("beforeExpiredTime = " + beforeExpiredTime);
        log.info("currentTime = " + currentTime);

        log.info("beforeExpiredDate = " + dateFormat.format(beforeExpiredDate));
        log.info("currentDate = " + dateFormat.format(currentDate));

        log.info((beforeExpiredTime <= currentTime)+"");
        log.info((beforeExpiredTime - currentTime)+"");


        if (beforeExpiredTime <= currentTime){
            log.info("====>>>>>");
            response.setHeader(CommonConstant.REFRESH_TOKEN,"123456");
        }

    }


}
