package edu.service;

import java.io.InputStream;
import java.util.List;

import edu.po.Users;
import edu.vo.UserVO;

public interface UserService {
	
	   public List<Users>  findAll();
	     
	   public void save(UserVO uservo);
	   
	   /**
	    * 判断用户名、密码是否和数据库匹配，返回空字符串或null则表明匹配，否则不匹配
	    * @param uservo
	    * @return 错误提示信息
	    */
	   public String checkLogin(UserVO uservo);
	   
	   public Users findByUserName(String userName);
	   
	   public InputStream getInputStream();
	   

}
