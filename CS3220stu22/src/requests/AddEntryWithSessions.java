package requests;

import models.GuestBookEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/requests/AddEntryWithSessions")
@SuppressWarnings("unchecked")
public class AddEntryWithSessions extends HttpServlet {
  private static final long serialVersionUID = 1L;


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("	<meta charset=\"UTF-8\">");
    out.println("	<title>Insert title here</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<h1>Add Entry with Sessions</h1>");

    out.println("<form action=\"AddEntryWithSessions\" method=\"post\">");

    String name = (String) request.getSession().getAttribute("name");

    if (name == null)
      out.println("  Name: <input type=\"text\" name=\"name\" /> <br />");
    else
      out.println("  Name: <strong>" + name + "</strong> <br />");

    out.println("  Message: <input type=\"text\" name=\"message\" /> <br />");
    out.println("  <input type=\"submit\" />");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();

    String name = (String) session.getAttribute("name");

    // Did the attribute exist?
    if (name == null) {

      // Read the name from the request object
      name = request.getParameter("name");

      // Add the name to the session
      session.setAttribute("name", name);
    }


    String message = request.getParameter("message");

    if (name != null && name.trim().length() > 0 &&
        message != null && message.trim().length() > 0) {

      // Get a reference to the guest book
      List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");

      // Add a new entry
      entries.add(new GuestBookEntry(name, message));
    }

    // Send the User back to the Guest Book page
    response.sendRedirect("GuestBook");
  }

}