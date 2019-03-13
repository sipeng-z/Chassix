package com.application;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component 
public class CorsFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		HttpServletResponse response = (HttpServletResponse) res;  
		  
        HttpServletRequest reqs = (HttpServletRequest) req;  
  
       // response.setHeader("Access-Control-Allow-Origin",reqs.getHeader("Origin"));  
        response.setHeader("Access-Control-Allow-Origin","*");  
        //response.setHeader("Access-Control-Allow-Credentials", "true");  
        response.setHeader("Access-Control-Allow-Methods", "PUT,POST, GET, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
       // response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");  
        
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");  
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Authorization");  
        
        
       // response.setHeader("Access-Control-Allow-Origin", "*");  
//      response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,token");  
      ///  response.setHeader("Access-Control-Allow-Headers", "Content-Type,token"); // 加入支持自定义的header 加入元素 token 前端就可以发送自定义token过来  
      //  response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
      //  response.setHeader("X-Powered-By"," 3.2.1");  
      //  response.setHeader("Content-Type", "application/json;charset=utf-8");  
        
        
        chain.doFilter(req, res);  
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

   
}
