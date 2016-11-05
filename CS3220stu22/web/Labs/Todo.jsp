<%--
  Created by IntelliJ IDEA.
  User: kcr12
  Date: 5/11/2016
  Time: 上午 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>CS 3220 — To Do App</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

  <link rel="bootstrap.min.css" type="text/css" crossorigin="anonymous">

</head>
<body>

<div class="container-fluid">
  <div class="page-header">
    <h1>ToDo
      <small>CS3220</small>
    </h1>
  </div>

  <form>

  </form>

  <table class="table table-bordered table-striped table-hover">
    <tr>
      <th>Title</th>
      <th>Action</th>
    </tr>

    <tr>
      <td>Make a todo list</td>
      <td><a class="btn btn-primary" href="update?id=1">Mark as Done</a></td>
    </tr>

    <tr>
      <td>Add an item to todo list</td>
      <td><a class="btn btn-primary" href="update?id=2">Mark as Done</a></td>
    </tr>

    <tr>
      <td><s>Complete item on todo list</s></td>
      <td><a class="btn btn-success" href="update?id=3">Mark as Not Done</a></td>
    </tr>
  </table>

</div>
</body>
</html>
