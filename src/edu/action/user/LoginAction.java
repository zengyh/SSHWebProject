package edu.action.user;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import edu.po.Users;
import edu.service.UserService;
import edu.vo.UserVO;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -1651073557745396752L;
	
	private UserService  userservice;
    public UserVO uservo;
    public ArrayList<Users> userlist;
    public boolean loginfail = false; 
    public String errorMsg;

	public UserVO getUservo() {
		return uservo;
	}

	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	
	public boolean getLoginfail() {
		return loginfail;
	}

	public void setLoginfail(boolean loginfail) {
		this.loginfail = loginfail;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String execute() throws Exception {
	    errorMsg = this.userservice.checkLogin(uservo);
		if( errorMsg == null || errorMsg.equals("") ){ //登陆成功
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", uservo);		
			return "success";
		}else{
			loginfail = true;
			return "input";
		}

	}
}
