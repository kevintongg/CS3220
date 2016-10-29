<%@ page import="tictactoe.TicTacToeExample" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<html>
<body bgcolor="white">
<size
=5 color="red">

<%
  HttpSession sess = request.getSession(true);
  TicTacToeExample board = (TicTacToeExample) session.getAttribute("board");

  String first = null;

  try {
    first = request.getParameterValues("first")[0];
  } catch (NullPointerException e) {
    out.println("woops");
  }

  String[] moves = request.getParameterValues("move");
  if (moves != null) {
    String move = moves[0];

    boolean moveResult = false;
    try {
      int actualMove = new Integer(move);
      if (actualMove >= 1 && actualMove <= 9) {
        moveResult = board.move(actualMove);
      }
    } catch (Exception e) {
      out.println("well that didn't work.");
    }

    if (!moveResult) {
      out.println("not quite. give it another go!");
    }
    if (moveResult)
      out.println("<br>");
  } else {
    out.println("<br>");
  }
  try {
    if (first.equals("computer")) {
      if (board.getTurn(true) == 'X') {
        board.move(board.evaluateBestMove());
      }
    } else {
      if (board.getTurn(true) == 'O') {
        board.move(board.evaluateBestMove());
      }
    }
  } catch (NullPointerException e) {
    out.println("woops");
  }
%>

<pre>
<%
  out.println(board);
%>
</pre>

<%
  try {
    if (board.isGameOver()) {
      out.println("The activeGame is: ");
      if (board.getWinner() == ' ') {
        out.println("a tie!");
      } else {
        out.println(board.getWinner());
      }
    } else {
%>

<p>Enter a move:</p>
<pre>
1|2|3
-----
4|5|6
-----
7|8|9
</pre>
<form method="get" action="play.jsp">
  <input type="text" name="move" value="">
  <input type="hidden" name="first" value="<%out.print(first);%>">
  <input type="submit" name="submit" value="Play move">
</form>
<%
    }
  } catch (NullPointerException e) {
    out.println("woops");
  }
%>


<p>
  <a href="index.jsp">new activeGame</a>
</p>

</font>
</body>
</html>