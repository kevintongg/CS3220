package todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Labs/Todo")
public class Todo extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "  <head>\n" +
        "    <meta charset=\"utf-8\">\n" +
        "    <title>To-Do List</title>\n" +
        "  </head>");

    List<TodoList> entries = new ArrayList<>();
    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs3220stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from todo_list");

      while (resultSet.next()) {
        TodoList entry = new TodoList(resultSet.getString("title"));
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

    out.println("  <body>\n" +
        "\n" +
        "  </body>\n" +
        "</html>");

    request.setAttribute("entries", entries);
    request.getRequestDispatcher("/Labs/Todo.jsp/").forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  }
}
