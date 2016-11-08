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

  <form class="form-inline" action="Todo" method="post">
    <div class="form-group">
      <span id="remaining">2</span> of <span id="total">3</span> Todos [ <a href="Archive">Archive</a> ]
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="Enter a Todo">
    </div>
    <button type="submit" class="btn btn-default">Add</button>
  </form>

  <table class="table table-bordered table-striped table-hover">
    <tr>
      <th>Title</th>
      <th>Action</th>
    </tr>

    <tr>
      <td>Make a todo list</td>
      <td>
        <a class="btn btn-primary btn-sm" href="Update?id=1&state=done">Mark as Done</a>
      </td>
    </tr>

    <tr>
      <td>Add an item to todo list</td>
      <td>
        <a class="btn btn-primary btn-sm" href="Update?id=2&state=done">Mark as Done</a>
      </td>
    </tr>

    <tr>
      <td>
        <s>Complete an item on todo list</s>
      </td>
      <td>
        <a class="btn btn-success btn-sm" href="Update?id=3&state=notdone">Mark as Not Done</a>
      </td>
    </tr>
  </table>
</div>
</body>
</html>