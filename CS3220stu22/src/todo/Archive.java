package todo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Labs/Archive")
public class Archive extends HttpServlet {
  public Archive() {
    super();
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM items");
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

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    super.doPost(request, response);
  }
}
