package sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessions/Members")
public class Members extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = (String) request.getSession().getAttribute("username");


    // check if a user has logged in or not
    if (request.getSession().getAttribute("user") == null) {
      response.sendRedirect("Login");
      return;
    }

    // if the user is logged in, display the members-only content
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head><title>Member-Only Area</title></head>");
    out.println("<body>");
    out.println("<h1>Member-Only Area!</h1>");
    out.println("<h2> Welcome, " + name + "!</h2>");
    out.println("<a href='Logout'>Logout</a>");
    out.println("</body></html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
