package edu.action.user;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import edu.po.Users;
import edu.service.UserService;
import edu.vo.UserVO;

public class SaveUserAction extends ActionSupport{

	private static final long serialVersionUID = -1651073557745396752L;
	
	private UserService  userservice;
    public UserVO uservo;
    public ArrayList<Users> userlist;
    public boolean exist = false;

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

	public boolean getExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(this.userservice.findByUserName(uservo.getUsername()) == null){
			this.userservice.save(uservo);
			userlist = (ArrayList<Users>) this.userservice.findAll();
			return "success";
		}else{
			this.exist = true; //用户已经存在！
			return "input";
		}


	}
}
