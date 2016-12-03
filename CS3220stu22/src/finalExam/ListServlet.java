package finalExam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Final/List")
public class ListServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    List<Item> items = new ArrayList<>();

    Connection connection = null;

    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM reddit ORDER BY points DESC, link DESC");

      while (resultSet.next()) {
        Item item = new Item(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("link"), resultSet.getInt("points"));
        items.add(item);
      }
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

    request.setAttribute("links", items);
    request.getRequestDispatcher("/WEB-INF/Final.jsp").forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
