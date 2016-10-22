<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 22/10/2016
  Time: 上午 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  if (request.getParameter("reset") != null) {
    session.removeAttribute("board");
  }
%>
</body>
</html>
