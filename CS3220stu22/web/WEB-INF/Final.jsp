<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 3/12/2016
  Time: 上午 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <title>Reddit</title>

  <link href="../css/paper-bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
  <div class="page-header text-center">
    <h1>Welcome to Reddit!</h1>
  </div>

  <form action="AddLink" method="get">
    <div class="form-group">
      <label for="title">Title</label>
      <input name="title" type="text" class="form-control" id="title" placeholder="Title">
    </div>
    <div class="form-group">
      <label for="url">Link</label>
      <input name="url" type="text" class="form-control" id="url" placeholder="Link">
    </div>
    <div class="text-right">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form>

  <c:if test="${empty links}">
    <div class="jumbotron text-center">
      <h1>Uh-Oh!
        <small>There are no links to display.</small>
      </h1>
    </div>
  </c:if>

  <c:if test="${not empty links}">
    <div class="text-center">
      <c:forEach items="${links}" var="links">
        <div class="text-center">
          <span class="count" style="font-size: 20px;">${links.points}</span> points
          <br/>
          <strong><c:out value="${links.title}"/></strong>
          <br/>
          <div class="link">
            <a style="text-decoration: none" href="${links.link}">${links.link}</a>
          </div>
          <br/>
          <c:url value="Upvote" var="upvoteUrl">
            <c:param name="id" value="${links.id}"/>
          </c:url>
          <a href="${upvoteUrl}">Upvote</a>
          <c:url value="Downvote" var="downvoteUrl">
            <c:param name="id" value="${links.id}"/>
          </c:url>
          <a href="${downvoteUrl}">Downvote</a>
        </div>
        <br/>
      </c:forEach>
    </div>
  </c:if>
</div>
</body>
</html>
