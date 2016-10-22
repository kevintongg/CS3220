<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 22/10/2016
  Time: 上午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="background" class="beans.BGBean"/>
<html>
<head>
  <title>BG Color</title>

  <jsp:setProperty name="background" property="*"/>

  <style>
    body {
      background-color: rgb(<jsp:getProperty name="background" property="r"/>,
      <jsp:getProperty name="background" property="g"/>, <jsp:getProperty name="background" property="b"/>);
    }
  </style>
</head>
<body>
<h1>Hello from BGColor.jsp!</h1>

<h3>
  Red:
  <jsp:getProperty name="background" property="r"/>
</h3>

<h3>Green:
  <jsp:getProperty name="background" property="g"/>
</h3>

<h3>
  Blue:
  <jsp:getProperty name="background" property="b"/>
</h3>

<form action="BGColor.jsp">
  <input type="text" name="r" placeholder="red">
  <input type="text" name="g" placeholder="green">
  <input type="text" name="b" placeholder="blue">
  <input type="submit">
</form>
</body>
</html>
