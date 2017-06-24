<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>登陆页面</title>
  </head>
  <body>
    <s:form action="login"  method="post" >
      <s:textfield name="uservo.username"  value="%{uservo.username}" label="%{getText('username')}"></s:textfield>
      <s:password name="uservo.password"  value="%{uservo.username}" label="%{getText('password')}"></s:password>
      <s:submit value="登陆"></s:submit>
    </s:form>
    <s:if test="loginfail"><font color="red"><s:property value="errorMsg"/></font></s:if><br>
    <a href="${pageContext.request.contextPath}/listOnlineUser.jsp">在线用户列表</a>
    <a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
  </body>
</html>
