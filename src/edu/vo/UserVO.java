package edu.vo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import edu.action.user.UserList;

/**
 * 
 * @author yh.zeng
 * 文件描述: 1）往Session中存放Users对象，则自动往UserList用户列表中添加该用户
 *          2）Session中移除Users对象，则自动从UserList用户列表中移除该用户
 */
public class UserVO implements java.io.Serializable,  HttpSessionBindingListener  {
	
	private static final long serialVersionUID = 7132790140796457462L;
	
	// Fields
	private Integer id;
	private String username;
	private String password;

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
         UserList.getInstance().addUser(this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
         UserList.getInstance().removeUser(this);
    }
    

}