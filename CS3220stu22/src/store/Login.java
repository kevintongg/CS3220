package store;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Store/Login")
public class Login extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init(ServletConfig config) throws ServletException {

    super.init(config);

    List<User> users = new ArrayList<>();

    users.add(new User("kevin@tong.com", "asdf"));

    getServletContext().setAttribute("users", users);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "\t<meta charset=\"utf-8\">\n" +
        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "\t<title>Login</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n" +
        "\n" +
        "<body>\n");

    // Read email/password if they exist
    String email = request.getParameter("email") == null || request.getAttribute("emailError") != null ? "" : request.getParameter("email");
    String password = request.getParameter("password") == null || request.getAttribute("passwordError") != null ? "" : request.getParameter("password");

    out.println("<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Login</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"form-inline\" method=\"post\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email\" value=\"" + email + "\">\n");
    if (request.getAttribute("emailError") != null) {
      out.println("<h5 style=\"color: red\">Invalid/Incorrect email! Please try again!</h5>");
    }
    out.println("\t\t</div>\n" +
        "<br />" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" value=\"" + password + "\">\n");
    if (request.getAttribute("emailError") != null) {
      out.println("<h5 style=\"color: red\">Invalid/Incorrect password! Please try again!</h5>");
    }
    out.println("<br />");
    out.println("\t\t</div>\n" +
        "\t\t<br />" +
        "\t\t<div class=\"checkbox\">\n" +
        "\t\t\t<label>\n" +
        "\t\t\t\t<input type=\"checkbox\" name=\"rememberMe\"> Remember me\n" +
        "\t\t\t</label>\n" +
        "\t\t</div>\n" +
        "\t\t<br />" +
        "\t\t<button type=\"submit\" class=\"btn btn-default\">Sign in</button>\n" +
        "\t</form>\n" +
        "\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>");


  }

  @Override
  @SuppressWarnings("unchecked")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext context = this.getServletContext();

    HttpSession session = request.getSession();

    List<User> users = (ArrayList<User>) context.getAttribute("users");

    boolean hasError = false;

    String email = request.getParameter("email");
    String checkBox = request.getParameter("rememberMe");

    // Did the cookie exist?
    if (checkBox != null) {
      // Read the name from the request object
      email = request.getParameter("email");
      // Create the email cookie
      Cookie cookie = new Cookie("username", email);
      // Send the cookie back to the browser
      response.addCookie(cookie);
    }

    // Validate the e-mail
    for (User user : users) {
      if (email == null || user.getEmail().trim().length() == 0 || !user.getEmail().equals(email)) {
        hasError = true;
        request.setAttribute("emailError", true);
      }
    }

    String password = request.getParameter("password");

    for (User user : users) {
      if (password == null || user.getPassword().trim().length() == 0 || !user.getPassword().equals(password) && user.getEmail().equals(email)) {
        hasError = true;
        request.setAttribute("passwordError", true);
      }
    }

    if (hasError) {
      doGet(request, response);
    } else {
      for (User user : users) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
          request.getSession().setAttribute("CurrentUser", user);

//          // Did the attribute exist?
//          if (name == null) {
//
//            // Read the name from the request object
//            name = request.getParameter("name");

          // Add the name to the session
          session.setAttribute("CurrentUser", user);
//          }

          response.sendRedirect("Inventory");
        }
      }
    }
  }
}
