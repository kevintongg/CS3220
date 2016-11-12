package todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Labs/Todo")
public class TodoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }

    List<Todo> todos = new ArrayList<>();
    List<Todo> archived = new ArrayList<>();
    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM list");

      while (resultSet.next()) {
        Todo todo = new Todo(resultSet.getInt("id"), resultSet.getString("description"), resultSet.getString("state"));
        if (todo.getState().equals("archived")) {
          archived.add(todo);
        } else {
          todos.add(todo);
        }
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

    int count = 0;

    for (Todo todo : todos) {
      if (todo.getState().equals("notdone")) {
        count++;
      }
    }

    request.setAttribute("remaining", count);
    request.setAttribute("todos", todos);
    request.setAttribute("archived", archived);
    request.getRequestDispatcher("/WEB-INF/Todo.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String description = request.getParameter("description");

    if (description == null) {
      request.setAttribute("error", "Invalid input! Try inputting your description again!");
      doGet(request, response);
      return;
    }

    description = description.trim();

    if (description.equals("")) {
      request.setAttribute("error", "Invalid input! Try inputting your description again!");
      doGet(request, response);
      return;
    }

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

      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO list VALUES (NULL, ?,\"notdone\")");
      preparedStatement.setString(1, description);

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

    response.sendRedirect("/Labs/Todo");
  }
}
