package edu.threadlocal;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import edu.vo.UserVO;

/**
 * Title: RequestContext.java
 * Description: 请求上下文 (存放了HttpSession、HttpServletRequest等对象)
 *              这个类不推荐使用，作为替换请使用LocalRequestContextHolder类
 * @author yh.zeng
 * @date 2017-6-21
 */
@Deprecated()
public class RequestContext {

	private ServletContext servletContext;
	private HttpSession session;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Cookie> cookies;
	private UserVO currentUser;  //当前登陆用户
	
	private final static ThreadLocal<RequestContext> contexts = new ThreadLocal<RequestContext>();
	
	private RequestContext(){}
	
	/**
	 * 初始化请求上下文
	 * @param ctx
	 * @param req
	 * @param res
	 */
	public static RequestContext begin(ServletContext ctx, HttpServletRequest req, HttpServletResponse res) {
		RequestContext rc = new RequestContext();
		rc.servletContext = ctx;
		rc.request = req;
		rc.response = res;
		rc.session = req.getSession();
		rc.cookies = new HashMap<String, Cookie>();
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie ck : cookies) {
				rc.cookies.put(ck.getName(), ck);
			}
		}
		//当前用户信息
		Object userObj = req.getSession().getAttribute("user");
		if(userObj != null){
			rc.currentUser = (UserVO)userObj;
		}
		contexts.set(rc);
		return rc;
	}
	
	/**
	 * 获取当前请求的上下文
	 * @return
	 */
	public static RequestContext getLocalRequestContext(){
		return contexts.get();
	}
	
    /**
     * 清除当前线程对请求上下文对象的引用（即让GC回收当前请求上下文对象）
     */
	public void destroy() {
		this.servletContext = null;
		this.request = null;
		this.response = null;
		this.session = null;
		this.cookies = null;
		contexts.remove();
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Cookie> getCookies() {
		return cookies;
	}

	public void setCookies(Map<String, Cookie> cookies) {
		this.cookies = cookies;
	}

	public UserVO getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(UserVO currentUser) {
		this.currentUser = currentUser;
	} 
	
	
	
}