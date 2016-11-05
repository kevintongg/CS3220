<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty entry}">
  <c:redirect url="GuestBook.jsp"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
  <title>Edit Comment</title>
</head>
<body>
<form action="EditComment.jsp" method="post">

  <c:if test="${not empty nameError}">
    <p style="color: #f00;">Please enter a valid name.</p>
  </c:if>
  Name: <input type="text" name="name" value="${entry.name}"/> <br/>

  <c:if test="${not empty messageError}">
    <p style="color: #f00;">Please enter a valid message.</p>
  </c:if>
  <textarea name="message">${entry.message}</textarea> <br/>

  <input type="hidden" name="id" value="${entry.id}"/>

  <input type="submit" name="save" value="Save"/>
</form>
</body>
</html>