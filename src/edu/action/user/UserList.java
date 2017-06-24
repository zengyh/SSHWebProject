package edu.action.user;

import java.util.Enumeration;
import java.util.Vector;
import edu.vo.UserVO;

/**
 * 文件名称: UserList.java
 * 编写人: yh.zeng
 * 编写时间: 17-1-5 下午7:48
 * 文件描述: 已登录的用户列表（在线用户列表）
 */
public class UserList
{
    private static UserList userList = new UserList();

    private Vector<UserVO>  v = null;


    private UserList(){
        v = new Vector<UserVO>();
    }


    public static UserList getInstance(){
        return userList;
    }


    public void addUser(UserVO user){
        if(user != null && !v.contains(user)){
            v.add(user);
        }
    }

    public void removeUser(UserVO user){
        if(user != null){
            v.remove(user);
        }
    }

    public Enumeration<UserVO>  getUserList(){
        return v.elements();
    }

    public int getUserCount(){
        return v.size();
    }


}
