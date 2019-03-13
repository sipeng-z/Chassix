package com.authorize.oauth2;

import com.alibaba.fastjson.JSONObject;
import com.authorize.AuthorizeJwt;
import com.authorize.CurrentUserInfo;
import com.model.AppConsts;
import io.jsonwebtoken.Claims;

import javax.servlet.http.HttpServletRequest;

public class OAuth2Manager {

	public CurrentUserInfo GetCurrentUserInfo(HttpServletRequest request) {
		CurrentUserInfo currentUserInfo = null;
		try {
			if (request != null) {
				String headerAuthorization = request.getHeader("Authorization");
				System.out.println("headerAuthorization=" + headerAuthorization);
				if ((headerAuthorization != null) && (headerAuthorization.length() > 7)) {
					String tokenType = headerAuthorization.substring(0, 6).toLowerCase();
					if (tokenType.compareTo("bearer") == 0) {
						headerAuthorization = headerAuthorization.substring(7, headerAuthorization.length());
						if (!headerAuthorization.equals("undefined")) {
							AuthorizeJwt jwt = new AuthorizeJwt();
							Claims claims = null;
							claims = jwt.parseJWT(headerAuthorization);
							String json = claims.getSubject();
							currentUserInfo = JSONObject.parseObject(json, CurrentUserInfo.class);
							if (currentUserInfo != null) {
								if (currentUserInfo.getUserId().equals(AppConsts.defaultGuId) || "".equals(currentUserInfo.getUserId())) {
									currentUserInfo = null;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentUserInfo;
	}

	public String GetAccessToken(HttpServletRequest request) {
		String rtHeaderAuthorization = "";
		try {
			if (request != null) {
				String headerAuthorization = request.getHeader("Authorization");
				System.out.println("headerAuthorization=" + headerAuthorization);
				if ((headerAuthorization != null) && (headerAuthorization.length() > 7)) {
					String tokenType = headerAuthorization.substring(0, 6).toLowerCase();
					if (tokenType.compareTo("bearer") == 0) {
						rtHeaderAuthorization = headerAuthorization.substring(7, headerAuthorization.length());
						if (rtHeaderAuthorization.equals("undefined")) {
							rtHeaderAuthorization = "";
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtHeaderAuthorization;
	}

}
