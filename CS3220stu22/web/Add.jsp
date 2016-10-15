<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 15/10/2016
  Time: 上午 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add</title>
</head>
<body>
<%
  String a = request.getParameter("a");
  String b = request.getParameter("b");

  int sum;

  try {
    sum = Integer.parseInt(a) + Integer.parseInt(b);
  } catch (NumberFormatException e) {
    response.sendRedirect("AddForm.html");
    return;
  }

%>

<p>
  The sum of <%= request.getParameter("a")%> and <%= request.getParameter("b") %>
  = <%= Integer.parseInt(request.getParameter("a")) + Integer.parseInt(request.getParameter("b"))%>
</p>
</body>
</html>
