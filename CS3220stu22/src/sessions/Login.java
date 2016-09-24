package sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/sessions/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("<title>Login</title>");
    out.println("</head>");
    out.println("<body>");

    String error = (String) request.getAttribute("error");

    if (error != null) {
      out.println("<h1 style=\"color: red\">" + error + "</h1>");
    }

    // Read the username and password if it exists
    String username = request.getParameter("username") == null ? "" : request.getParameter("username");
    String password = request.getParameter("password") == null ? "" : request.getParameter("password");

    out.println("<div class=\"container\">");
    out.println("<form action='Login' method='post'>");
    out.println("Username: <input type='text' name='username' value='" + username + "'/> <br />");
    out.println("Password: <input type='password' name='password' value='" + password + "' /> <br />");
    out.println("<input type='submit' name='login' value='Login' /> <br />");
    out.println("</form>");
    out.println("</div>");

    out.println("</body></html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if (request.getParameter("username").equals("kevin") && request.getParameter("password").equals("abcd")) {
      request.getSession().setAttribute("user", "kevin");
      response.sendRedirect("Members");
    } else {
      // We get here if the username or password is incorrect
      request.setAttribute("error", "Invalid username and/or password!");

      doGet(request, response);
    }
  }
}
