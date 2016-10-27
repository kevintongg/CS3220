<%@ page import="tictactoe.TicTacToeExample" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<HTML>

<%
  HttpSession sess = request.getSession(true);
  session.setAttribute("board", new TicTacToeExample());
%>

<BODY bgcolor="white">


<FORM TYPE=POST ACTION=play.jsp>
  <BR>
  <font size=5 color="red">
    Who shall go first?

    <br>

    <INPUT TYPE=radio name="first" Value="user"> I'll go first!
    <br>
    <INPUT TYPE=radio name="first" Value="computer" checked> The computer can go.
    <br>
    <INPUT TYPE=submit name=submit Value="Play!">

  </font>
</FORM>

</font>

</BODY>
</HTML>