package finalExam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/Final/Upvote")
public class Upvote extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String id = request.getParameter("id");

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);

      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE reddit SET points=points + 1 WHERE id=?");
      preparedStatement.setString(1, id);

      preparedStatement.execute();

    } catch (SQLException e) {
      throw new ServletException(e);
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException e) {
        throw new ServletException(e);
      }
    }

    response.sendRedirect("List");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
