

package com.spring.web.core.constant;

/**
 * <p>
 *  redis key 常量
 * </p>
 * @author zhaobohao
 * @date 2019-05-23
 **/
public interface CommonRedisKey {

    /**
     * 系统登录用户
     */
    String LOGIN_SYS_USER = "login:sys:user:%s";
    /**
     * 系统登录token
     */
    String LOGIN_TOKEN = "login:token";

}
