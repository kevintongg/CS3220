package jdbc;

import models.GuestBookEntryMVC;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/GuestBookJDBC", loadOnStartup = 1)
public class GuestBookJDBC extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public GuestBookJDBC() {
    super();
  }

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new ServletException(e);
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    List<GuestBookEntryMVC> entries = new ArrayList<>();
    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from guestbook");

      while (resultSet.next()) {
        GuestBookEntryMVC entry = new GuestBookEntryMVC(resultSet.getString("name"), resultSet.getString("message"));
        entries.add(entry);
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

    request.setAttribute("entries", entries);
    request.getRequestDispatcher("/WEB-INF/GuestBook.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}