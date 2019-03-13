package com.session;


import com.session.general.GeneralHttpSession;

public class HttpSessionManager {

	private HttpSessionInterface _HttpSessionInterface = null;

	public HttpSessionManager() {
		_HttpSessionInterface = new GeneralHttpSession();
	}

	public HttpSessionInterface Instance()
	{
		return _HttpSessionInterface;
	}

}
