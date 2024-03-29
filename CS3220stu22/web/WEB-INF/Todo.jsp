<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 5/11/2016
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">


  <title>Todo</title>

  <link href="../css/paper-bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

  <!-- Page Header -->
  <div class="page-header text-center">
    <h2>
      Todo
      <small>
        <span id="remaining">${remaining}</span>
        of
        <span id="total">${fn:length(todos)}</span>
        remaining
        <small>
          [<a style="text-decoration: none" href="Archive">Archive</a>]
        </small>
        <small>
          [<a style="text-decoration: none" href="Reset">Reset</a>]
        </small>
      </small>
    </h2>
  </div>

  <form action="Todo" method="post">
    <div class="row">
      <div class="col-xs-9 col-sm-10">
        <div class="form-group">
          <label class="sr-only" for="description">Todo Description</label>
          <input type="text" class="form-control" id="description" name="description"
                 placeholder="Enter todo description" autofocus>
        </div>
        <c:if test="${not empty error}">
          <p class="well-sm bg-danger">${error}</p>
        </c:if>
      </div>
      <div class="col-xs-3 col-sm-2">
        <button type="submit" class="btn btn-success btn-block">Add Todo</button>
      </div>
    </div>
  </form>

  <c:if test="${empty todos}">
    <div class="jumbotron text-center">
      <h1>Uh-Oh!
        <small>There are no tasks to display.</small>
      </h1>
    </div>
  </c:if>

  <c:if test="${not empty todos}">
    <table class="table table-hover table-striped table-bordered">
      <thead>
      <tr>
        <th>Task</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${todos}" var="todo">
        <tr>
          <td>
            <c:choose>
              <c:when test="${todo.notDone}">
                <c:out value="${todo.description}"/>
              </c:when>
              <c:otherwise>
                <s><c:out value="${todo.description}"/></s>
              </c:otherwise>
            </c:choose>
          </td>
          <td>

              <%-- Construct the Update URL --%>
            <c:url value="Update" var="updateUrl">
              <c:param name="id" value="${todo.id}"/>
              <c:param name="state" value="${todo.oppositeState}"/>
            </c:url>

            <c:choose>
              <c:when test="${todo.notDone}">
                <a class="btn btn-primary btn-xs" href="${updateUrl}">Mark as Done</a>
              </c:when>
              <c:otherwise>
                <a class="btn btn-default btn-xs" href="${updateUrl}">Mark as Not Done</a>
              </c:otherwise>
            </c:choose>

            <c:url value="Delete" var="deleteItem">
              <c:param name="id" value="${todo.id}"/>
            </c:url>

            <a class="btn btn-danger btn-xs" href="${deleteItem}">Delete Item</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>

  <hr/>

  <div class="page-header text-center">
    <h2>Archived
      <small>
        <span id="totalArchived">${fn:length(archived)} todo(s)</span>
        have been archived.
      </small>
    </h2>
  </div>

  <c:if test="${empty archived}">
    <div class="well">
      <h3 class="text-center">No Items have been archived.</h3>
    </div>
  </c:if>

  <c:if test="${not empty archived}">

    <table class="table table-hover table-striped table-bordered">
      <thead>
      <tr>
        <th>Task</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${archived}" var="todo">
        <tr>
          <td>
            <c:choose>
              <c:when test="${todo.notDone}">
                ${todo.description}
                <c:out value="${todo.description}"/>
              </c:when>
              <c:otherwise>
                <s><c:out value="${todo.description}"/></s>
              </c:otherwise>
            </c:choose>
          </td>
          <td>

            <c:url value="Update" var="updateUrl">
              <c:param name="id" value="${todo.id}"/>
              <c:param name="state" value="${todo.oppositeState}"/>
            </c:url>

            <a class="btn btn-default btn-xs" href="${updateUrl}">Mark as Not Done</a>

            <c:url value="Delete" var="deleteItem">
              <c:param name="id" value="${todo.id}"/>
            </c:url>

            <a class="btn btn-danger btn-xs" href="${deleteItem}">Delete Item</a>

          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>
</body>
</html>