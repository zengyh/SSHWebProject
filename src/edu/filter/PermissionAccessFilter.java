package edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Title: PermissionAccessFilter.java
 * Description: 权限过滤器
 * @author yh.zeng
 * @date 2017-6-20
 */
public class PermissionAccessFilter implements Filter {
	
	private Logger logger = Logger.getLogger(PermissionAccessFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterChan) throws IOException, ServletException{
		HttpServletRequest request = (HttpServletRequest)req;
		if(request.getSession().getAttribute("user") == null){ //用户没有登录
			String url=request.getServletPath(); 
			if(url.equals("/login.jsp") || url.indexOf("/exception/") == 0 || url.equals("/login.action")){
				filterChan.doFilter(req, res);
			}else{
				logger.error("没有权限访问"+url+"页面，请先登录系统！");
				((HttpServletResponse)res).sendRedirect("exception/NoPermissionException.jsp");
			}
		}else{
			filterChan.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	

}
