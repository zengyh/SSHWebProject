package edu.action.user;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import edu.po.Users;
import edu.service.UserService;

public class ListUserAction extends ActionSupport {
	
	private static final long serialVersionUID = -5919063614671472698L;

    public ArrayList<Users> userlist;
    public UserService userservice;

	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public ArrayList<Users> getUserlist() {
		return userlist;
	}

	public void setUserlist(ArrayList<Users> userlist) {
		this.userlist = userlist;
	}
    
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		userlist = (ArrayList<Users>) this.userservice.findAll(); 
		return "success";
	}
	
}
