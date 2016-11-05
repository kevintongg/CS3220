package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//5*tf4x*j

@WebServlet("/HelloJDBC")
class HelloJDBC extends HttpServlet {

  private static final long serialVersionUID = 1L;

  public HelloJDBC() {
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

  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0");
    out.print("Transitional//EN\">\n");
    out.print("<html><head><title>Hello JDBC</title></head>\n<body>");

    Connection connection = null;
    try {
      String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu22";
      String username = "cs320stu22";
      String password = "!z6j98!z";

      connection = DriverManager.getConnection(url, username, password);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from items");

      while (resultSet.next()) {
        out.println(resultSet.getString("name"));
        out.println(resultSet.getString("price"));
        out.println(resultSet.getFloat("quantity"));
        out.println("<br />");
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

    out.print("</body></html>");
  }

}