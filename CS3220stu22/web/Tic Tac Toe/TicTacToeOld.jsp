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

  <%--<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css" crossorigin="anonymous">--%>

</head>
<body>


<%
  class Game {

    private boolean win;
    private boolean newGame;
    private boolean endGame;
    private int turn;

    Game() {
      turn = 0;
    }

    public int getTurn() {
      return turn;
    }

    public void setTurn(int turn) {
      this.turn = turn;
    }

    public boolean isWin() {
      return win;
    }

    public void setWin(boolean win) {
      this.win = win;
    }

    public boolean isEndGame() {
      return endGame;
    }

    public void setEndGame(boolean endGame) {
      this.endGame = endGame;
    }

    public boolean isNewGame() {
      return newGame;
    }

    public void setNewGame(boolean newGame) {
      this.newGame = newGame;
    }
  }
%>

<%

  Game activeGame = new Game();

  char[][] board = new char[3][3];

  if (session.isNew()) {
    session.setAttribute("board", board);
  }

  if (session.getAttribute("board") == null) {
    board = new char[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; i < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  for (int i = 0; i < board.length; i++) {
    for (int j = 0; j < board[i].length; j++) {
      board[i][j] = '-';
    }
  }

  if (!activeGame.isEndGame()) {
    session.invalidate();
  }

  String location = request.getParameter("location");
  String reset = request.getParameter("reset");

%>

<br/>

<div class="container">

  <div class="page-header">
    <h1>
      <%
        if (activeGame.getTurn() % 2 == 0) {
      %>Player X's Turn <%
    } else if (activeGame.getTurn() % 2 != 0) { %>
      Player O's Turn
      <%
        }
      %>
      <small>Tic Tac Toe</small>
    </h1>
  </div>


  <div class="row">
    <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=0' class='thumbnail'>
        <%
          if (location == null) {
        %>
        <a style="text-decoration: none" href='TicTacToeOld.jsp?location=0' class='thumbnail'><img
            src='http://placehold.it/150/cccccc?text=_' alt='Open Space'></a>
        <%
        } else if (location.equals("0")) {
          if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'><img
            src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'><img
            src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=1' class='thumbnail'>
        <%
          if (location == null) {
        %>
        <a style="text-decoration: none" href='TicTacToeOld.jsp?location=0' class='thumbnail'>
          <img src='http://placehold.it/150/cccccc?text=_' alt='Open Space'></a>
        <%
        } else if (location.equals("1")) {
          if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=2' class='thumbnail'>
        <a style="text-decoration: none" href='TicTacToeOld.jsp?location=2' class='thumbnail'>
          <img src='http://placehold.it/150/cccccc?text=_' alt='Open Space'></a>
        <%
          if (location == "2") {
            if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
  </div> <!--  end row -->
  <div class="row">
    <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=3' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'>
        <%
          if (location == "3") {
            if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=4' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'>
        <%
          if (location == "4") {
            if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=5' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'><%
        if (location == "5") {
          if (activeGame.getTurn() % 2 == 0) {
      %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
  </div> <!--  end row -->
  <div class="row">
    <div class="col-sm-offset-3 col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=6' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'><%
        if (location == "6") {
          if (activeGame.getTurn() % 2 == 0) {
      %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=7' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'>
        <%
          if (location == "7") {
            if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
    <div class="col-sm-2 col-xs-4 text-center">
      <a href='TicTacToeOld.jsp?location=8' class='thumbnail'><img src='http://placehold.it/150/cccccc?text=_'
                                                                   alt='Open Space'>
        <%
          if (location == "8") {
            if (activeGame.getTurn() % 2 == 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=X' alt='X'></a>
        <%
          activeGame.setTurn(activeGame.getTurn() + 1);
        } else if (activeGame.getTurn() % 2 != 0) {
        %>
        <a style="text-decoration: none" href='#' class='thumbnail'>
          <img src='http://placehold.it/150/E8117F/ffffff?text=O' alt='O'></a>
        <%
              activeGame.setTurn(activeGame.getTurn() + 1);
            }
          }
        %></a>
    </div>
  </div> <!--  end row -->

  <%
    if (activeGame.getTurn() == 9) {
      activeGame.setEndGame(true);
    }
  %>

  <p class="text-center">
    <a href="TicTacToeOld.jsp?reset" class="btn btn-lg btn-primary">New Game</a>
  </p>
</div> <!-- end container -->
</body>
</html>