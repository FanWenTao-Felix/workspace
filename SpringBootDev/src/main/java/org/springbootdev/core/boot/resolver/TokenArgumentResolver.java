
package org.springbootdev.core.boot.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springbootdev.core.secure.SystemUser;
import org.springbootdev.core.secure.utils.SecureUtil;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Token转化User
 *
 * @author zhaobohao
 */
@Slf4j
public class TokenArgumentResolver implements HandlerMethodArgumentResolver {

	/**
	 * 入参筛选
	 *
	 * @param methodParameter 参数集合
	 * @return 格式化后的参数
	 */
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.getParameterType().equals(SystemUser.class);
	}

	/**
	 * 出参设置
	 *
	 * @param methodParameter       入参集合
	 * @param modelAndViewContainer model 和 view
	 * @param nativeWebRequest      web相关
	 * @param webDataBinderFactory  入参解析
	 * @return 包装对象
	 */
	@Override
	public Object resolveArgument(MethodParameter methodParameter,
								  ModelAndViewContainer modelAndViewContainer,
								  NativeWebRequest nativeWebRequest,
								  WebDataBinderFactory webDataBinderFactory) {
		return SecureUtil.getUser();
	}

}
