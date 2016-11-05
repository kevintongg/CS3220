<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 5/11/2016
  Time: 上午 8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <title>Add Comment</title>
</head>
<body>
<form action="AddComment" method="post">

  <c:if test="${ not empty param.add and empty param.name }">
    <p style="color: #f00;">Error! Please enter your name.</p>
  </c:if>
  Name: <input type="text" name="name" value="${param.name}"/> <br/>

  <c:if test="${ not empty param.add and empty param.message }">
    <p style="color: #f00;">Error! Please enter a message.</p>
  </c:if>
  <textarea name="message">${param.message}</textarea> <br/>


  <input type="submit" name="add" value="Add"/>
</form>
</body>
</html>