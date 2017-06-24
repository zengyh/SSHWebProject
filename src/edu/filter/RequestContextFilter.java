package edu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.threadlocal.RequestContext;

/**
 * Title: RequestContextFilter.java
 * Description: 初始化 RequestContext请求上下文 
 * @author yh.zeng
 * @date 2017-6-22
 */
public class RequestContextFilter implements Filter{

	private ServletContext servletContext;
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		   RequestContext.begin(servletContext, (HttpServletRequest)req, (HttpServletResponse)res);
		   chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
	}

}
