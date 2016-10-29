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

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="bootstrap.min.css" type="text/css" crossorigin="anonymous">

</head>
<body>
<div class="container">

  <%
    if (session.getAttribute("board") == null) {
      char[] board = new char[9];
      for (char i : board) {
        board[i] = ' ';
      }
      session.setAttribute("board", board);
    }

    char[] board = (char[]) session.getAttribute("board");

    if (session.getAttribute("player") == null) {
      session.setAttribute("player", 'X');
    }

    char player = (Character) session.getAttribute("player");

    if (request.getParameter("location") != null && !activeGame(board)) {
      int location = Integer.parseInt(request.getParameter("location"));
      if (board[location] == ' ') {
        board[location] = player;

        if (activeGame(board)) {
          request.setAttribute("activeGame", player);
        } else {
          player = player == 'X' ? 'O' : 'X';
          session.setAttribute("player", player);
        }
      }
    }
  %>

  <%!
    private static boolean activeGame(char[] board) {

      if ((board[1] == 'X' && board[5] == 'X' && board[9] == 'X')
          || (board[3] == 'X' && board[5] == 'X' && board[7] == 'X')
          || (board[1] == 'X' && board[4] == 'X' && board[7] == 'X')
          || (board[2] == 'X' && board[5] == 'X' && board[8] == 'X')
          || (board[3] == 'X' && board[6] == 'X' && board[9] == 'X')) {
        return true;
      } else if ((board[1] == 'O' && board[5] == 'O' && board[9] == 'O')
          || (board[3] == 'O' && board[5] == 'O' && board[7] == 'O')
          || (board[1] == 'O' && board[4] == 'O' && board[7] == 'O')
          || (board[2] == 'O' && board[5] == 'O' && board[8] == 'O')
          || (board[3] == 'O' && board[6] == 'O' && board[9] == 'O')) {
        return true;
      } else {
        return false;
      }
    }
  %>

  <div class="page-header">
    <h1 class="text-center">
      It is Player <%=player%>'s Turn!
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
