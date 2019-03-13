package com.session.general;



import com.session.HttpSessionInterface;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GeneralHttpSession implements HttpSessionInterface {

	/**
	 * httpSession存储器，sessionId:HttpSession
	 */
	private static final ConcurrentMap<String, HttpSession> sessionStorage = new ConcurrentHashMap<>();

	/**
	 * 用户ID与session管理存储器，userId:HttpSession
	 */
	private static final ConcurrentMap<String, HttpSession> userSessionStorage = new ConcurrentHashMap<>();

	@Override
	public Integer getUserIdBySession(HttpSession session) {
		if (session == null)
			return null;
		return getLoginUserId(session);

	}

	@Override
	public void removeUserId(Integer userId) {
		HttpSession session = userSessionStorage.get(userId);
		if (session != null) {
			// sessionStorage.remove(session.getId());
			// userSessionStorage.remove(userId.toString());
			try {
				session.removeAttribute("user-id");
			} catch (Exception ignored) {
				// do noting
			}
		}
	}

	@Override
	public void addUser(Integer userId, HttpSession session) {
		// sessionStorage.put(session.getId(), session);
		// userSessionStorage.put(userId.toString(), session);
		session.setAttribute("user-id", userId);
	}

	@Override
	public boolean isLogin(String userId) {
		return userSessionStorage.containsKey(userId);
	}

	/**
	 * 在HttpSession中获取当前登录的用户
	 *
	 * @param session
	 *            HttpSession
	 * @return 当前登录的用户
	 */
	public Integer getLoginUserId(HttpSession session) {
		try {
			return (Integer) session.getAttribute("user-id");
		} catch (Exception e) {
			System.out.println("getLoginUserId "+e.toString());
		}
		return null;
	}

}
