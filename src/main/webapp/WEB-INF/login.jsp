<%--
  Created by IntelliJ IDEA.
  User: danghongen
  Date: 2020/1/3
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login.do" method="post">
    username:<label>
    <input type="text" name="username"/>
</label><br>
    password:<label>
    <input type="password" name="password"/>
</label><br>
    <input type="submit" value="登陆">${error }
</form>
</body>
</html>
