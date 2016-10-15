<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 15/10/2016
  Time: 上午 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! private int counter = 1; %>
<html>
<head>
  <title>Request Counter</title>
</head>
<body>
<h1>You are visitor #<%=counter%>
</h1>
<%counter++;%>
</body>
</html>
