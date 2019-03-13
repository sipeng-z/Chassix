package com.session;

import javax.servlet.http.HttpSession;

public interface HttpSessionInterface {
	    /**
	     * 根据sessionId 获取用户ID
	     * @param sessionId 根据sessionId
	     * @return 用户信息
	     */
	    Integer getUserIdBySession(HttpSession session) ;

	    /**
	     * 根据用户ID从session中删除一个用户(下线)
	     *
	     * @param userId 要删除的用户ID
	     */
	    void removeUserId(Integer userId) ;

	    /**
	     * 添加一个用户
	     *
	     * @param userId  用户id
	     * @param session HttpSession
	     */
	    void addUser(Integer userId, HttpSession session) ;

	    /**
	     * 根据用户ID 判断用户是否已经登陆
	     *
	     * @param userId 用户ID
	     */
	    boolean isLogin(String userId);

}
