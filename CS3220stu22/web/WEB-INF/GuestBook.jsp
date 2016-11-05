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
  <title>GuestBook MVC</title>
</head>
<body>

<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Message</th>
    <th>Operations</th>
  </tr>

  <c:forEach items="${entries}" var="entry">
    <tr>
      <td>${entry.id}</td>
      <td>${entry.name}</td>
      <td><c:out value="${entry.message}" escapeXml="true"/></td>
      <td><a href="EditComment?id=${entry.id}">Edit</a></td>
    </tr>
  </c:forEach>
</table>

<p><a href="AddComment">Add Comment</a></p>

</body>
</html>