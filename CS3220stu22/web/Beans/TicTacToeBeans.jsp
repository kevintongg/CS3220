<%--
  Created by IntelliJ IDEA.
  User: Kevin Tong
  Date: 22/10/2016
  Time: 上午 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="game" class="beans.TicTacToe" scope="session"/>
<html>
<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Tic-Tac-Toe</title>

  <link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" crossorigin="anonymous">

  <style>
    table {
      margin: 0 auto;
    }
  </style>

</head>
<body>

<div class="container-fluid">
  <h1 class="page-header text-center">Tic-Tac-Toe
    <small>Beans</small>
  </h1>

  <h1 class="text-center">Turn #:
    <jsp:getProperty name="game" property="turn"/>
  </h1>
  <h2 class="text-center">Current Turn — Player
    <jsp:getProperty name="game" property="player"/>
  </h2>

  <br/>

  <table>
    <tr class="text-center">
      <td>
        <a href="TicTacToeBeans.jsp?location=0"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=1"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=2"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="TicTacToeBeans.jsp?location=3"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=4"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=5"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="TicTacToeBeans.jsp?location=6"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=7"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
      <td>
        <a href="TicTacToeBeans.jsp?location=8"><img src="http://cs3.calstatela.edu:8080/cs3220stu22/images/blank.png"/></a>
      </td>
    </tr>
  </table>

  <br/>

  <p class="text-center">
    <a href="TicTacToeBeans.jsp?reset" class="btn btn-lg btn-primary">New Game</a>
  </p>

</div>
</body>
</html>
