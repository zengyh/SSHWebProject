<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>List All User's Information</title>
  </head>
  
  <body>
    <center><h1>用户列表</h1></center>
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
       <s:iterator value="userlist" var="user">
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
    <a href="${pageContext.request.contextPath}/generateExcel.action">导出Excel文件</a> 
    <a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
  </body>
</html>
