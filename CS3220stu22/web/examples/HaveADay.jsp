<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 15/10/2016
  Time: 上午 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Have a day</title>
</head>
<body>
<% if (Math.random() < 0.5) { %>
<h3>Have a great day!</h3>
<%} else {%>
<h3>Have a lousy day!</h3>
<%}%>
</body>
</html>
