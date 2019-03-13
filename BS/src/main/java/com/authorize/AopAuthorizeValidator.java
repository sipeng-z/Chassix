package com.authorize;

import com.authorize.annotation.Authorize;
import com.authorize.oauth2.OAuth2Manager;

import com.exception.AuthorizeException;
import com.model.AppConsts;
import com.utils.ClassUtils;
import com.utils.WebUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class AopAuthorizeValidator extends AuthorizeValidator {

	protected AuthorizeValidatorConfig getConfig(ProceedingJoinPoint pjp) {
		// String cacheKey = StringUtils.concat(pjp.getTarget().getClass().getName(),
		// ".", AopUtils.getMethodName(pjp));
		AuthorizeValidatorConfig config = null;// configCache.get(cacheKey);
		if (config == null) {
			config = this.createConfig();
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			Authorize methodAuth = ClassUtils.getAnnotation(signature.getMethod(), Authorize.class);
			Authorize classAuth = ClassUtils.getAnnotation(pjp.getTarget().getClass(), Authorize.class);
			if (methodAuth == null && classAuth == null) {
				return null;
			}
			Set<Authorize> authorizes = new LinkedHashSet<>();
			if (classAuth != null && (methodAuth == null || methodAuth.merge())) {
				// if (classAuth.anonymous())
				// return null;
				authorizes.add(classAuth);
			}
			if (methodAuth != null) {
				// if (methodAuth.anonymous())
				// return null;
				authorizes.add(methodAuth);
			}
			config.addAnnotation(authorizes);
			// configCache.put(cacheKey, config);
		}
		return config;
	}

	public boolean validate(ProceedingJoinPoint pjp) {
		AuthorizeValidatorConfig config = getConfig(pjp);
		if (config == null)
			return true;

		System.out.println("validate  begin ...");

		HttpServletRequest request = WebUtils.getHttpServletRequest();

		OAuth2Manager manager = new OAuth2Manager();
		// api OAuth2 认证
		if (config.isApiSupport()) {
			String token = manager.GetAccessToken(request);
			if (token == null || token.equals("")) {
				throw new AuthorizeException("你未登录或登录身份信息已失效,请重新登录(invalid_token)", 401);
			}
		}

		CurrentUserInfo currentUserInfo = manager.GetCurrentUserInfo(request);
		if (currentUserInfo == null || currentUserInfo.getUserId().equals(AppConsts.defaultGuId) || "".equals(currentUserInfo.getUserId())) {
			throw new AuthorizeException("你未登录或登录身份信息已失效,请重新登录", 401);
		}

		// if (config.isEmpty())
		// return true;
		Map<String, Object> param = new LinkedHashMap<>();
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		String[] names = signature.getParameterNames();
		Object[] args = pjp.getArgs();
		for (int i = 0; i < names.length; i++) {
			param.put(names[i], args[i]);
		}
		param.put("paramsMap", param);

		return validate(currentUserInfo, param, config);

		// //return validate(user, param, config);
	}

}
