<%--
  Created by IntelliJ IDEA.
  User: Kevin Tong
  Date: 17/10/2016
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tic Tac Toe</title>

    <link rel="bootstrap.min.css" type="text/css" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="page-header">
        <h1 class="text-center">Player X's Turn
            <small>Tic Tac Toe</small>
        </h1>
    </div>

    <div class="row">
        <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=0' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=1' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=2' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=3' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=4' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=5' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
    </div> <!--  end row -->
    <div class="row">
        <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=6' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=7' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
        <div class="col-sm-2 col-xs-4 text-center">
            <a href='TicTacToe.jsp?location=8' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                      alt='Open Space'></a>
        </div>
    </div> <!--  end row -->

    <p class="text-center">
        <a href="TicTacToe.jsp?reset" class="btn btn-lg btn-primary">New Game</a>
    </p>
</div>
</body>
</html>
