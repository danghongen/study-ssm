<jsp:useBean id="user" scope="request" type="org.springframework.remoting.jaxws.JaxWsPortClientInterceptor"/>
<%--
  Created by IntelliJ IDEA.
  User: danghongen
  Date: 2020/1/3
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功登录</title>
</head>
<body>
欢迎你${user.username }
<a href="${pageContext.request.contextPath }/user/logout.do">退出</a>
</body>
</html>
