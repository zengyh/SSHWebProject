<%@ page language="java"  pageEncoding="UTF-8" import="edu.action.user.UserList,java.util.Enumeration,edu.vo.UserVO"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    Enumeration<UserVO> userlist = UserList.getInstance().getUserList();
    request.setAttribute("userlist", userlist);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>List All User's Information</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
       function clearCache(){
           $.post("${pageContext.request.contextPath}/servlet/clearCacheServlet",{cachekey:"/oscache/test1.jsp"},function(result){
               if(result == "success"){
                  alert("删除缓存成功！");
               }else{
                  alert("删除缓存失败！");
               }
           });
           return false;
       }
    </script>
  </head>
  
  <body>
    <center><h1>在线用户列表</h1></center>
    <table border="1" width="80%" align="center">
       <thead>
          <tr>
            <td>
                                       用户名
            </td>
            <td>
                                       密码
            </td>          
          </tr>
       </thead>
       <tbody>
       <s:iterator value="#request.userlist" var="user">
           <tr>
              <td>
                <s:hidden value="#user.id"></s:hidden>
                <s:property value="#user.username"/>
              </td>
              <td>
                <s:property value="#user.password"></s:property>
              </td>
           </tr>
       </s:iterator>
       </tbody>
    </table>
    <a href="javascript:void(0)" onclick="clearCache()">清除缓存</a>
  </body>
</html>
