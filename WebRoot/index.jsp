<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <s:form action="saveUser"  method="post" >
      <s:textfield name="uservo.username"  value="%{uservo.username}" label="%{getText('username')}"></s:textfield>
      <s:password name="uservo.password"  value="%{uservo.username}" label="%{getText('password')}"></s:password>
      <s:submit value="保存"></s:submit>
    </s:form>
    <s:if test="exist"><font color="red">用户已经存在！</font></s:if><br>
    <a href="${pageContext.request.contextPath}/login.jsp">登陆页面</a>
    <a href="${pageContext.request.contextPath}/listUser.action">查看所有用户</a>
    <a href="${pageContext.request.contextPath}/listOnlineUser.jsp">在线用户列表</a>
  </body>
</html>
