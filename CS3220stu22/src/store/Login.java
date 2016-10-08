package store;

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

  private String getEmail(HttpServletRequest request) {

    Cookie[] cookies = request.getCookies();

    // Are there any cookies?
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
          return cookie.getValue();
        }
      }
    }

    return "";
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

    String emailCookie = getEmail(request);

    out.println("<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Login</h1>\n" +
        "\t</div>\n" +
        "\n");

    if (request.getAttribute("emailError") != null || request.getAttribute("passwordError") != null) {
      out.println("\t<p class=\"text-center\"style=\"color: red\"><strong>Invalid/Incorrect password! Please try again!</strong></p>\n");
    }

    out.println("\t<form class=\"form-horizontal\" method=\"post\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Email:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">" +
        "\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email\" value=\"" + email + emailCookie + "\" autofocus>\n" +
        "\t\t\t</div>" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Password:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">" +
        "\t\t\t\t<input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" value=\"" + password + "\">\n");
    out.println("\t\t\t</div>" +
        "\t\t</div>\n" +
        "\t\t<div class=\"checkbox\">\n" +
        "\t\t\t<label><input type=\"checkbox\" name=\"rememberMe\"> Remember me</label>\n" +
        "\t\t</div>\n" +
        "\t\t<br />\n" +
        "\t\t<button type=\"submit\" class=\"btn btn-primary\">Sign in</button>\n" +
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

    boolean hasError = false;

    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String checkBox = request.getParameter("rememberMe");

    List<User> users = (ArrayList<User>) context.getAttribute("users");

    for (User user : users) {
      System.out.println(user.toString());
    }

    for (User user : users) {
      if (email == null || user.getEmail().trim().length() == 0) {
        hasError = true;
        request.setAttribute("emailError", true);
      } else if (!user.getEmail().equals(email)) {
        hasError = true;
        request.setAttribute("emailError", true);
      } else if (user.getEmail().equals(email)) {
        hasError = false;
        request.setAttribute("emailError", false);
        break;
      }
    }

    for (User user : users) {
      if (password == null || user.getPassword().trim().length() == 0) {
        hasError = true;
        request.setAttribute("passwordError", true);
      } else if (!user.getPassword().equals(password)) {
        hasError = true;
        request.setAttribute("passwordError", true);
      } else if (user.getPassword().equals(password)) {
        hasError = false;
        request.setAttribute("passwordError", false);
        break;
      }
    }

    // Did the cookie exist?
    if (checkBox != null) {
      // Read the name from the request object
      email = request.getParameter("email");
      // Create the email cookie
      Cookie cookie = new Cookie("username", email);
      cookie.setMaxAge(60 * 30); // 30 Minutes
      // Send the cookie back to the browser
      response.addCookie(cookie);
    }

    if (hasError) {
      doGet(request, response);
    } else {
      for (User user : users) {
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
          request.getSession().setAttribute("CurrentUser", user);
          session.setAttribute("CurrentUser", user);
          response.sendRedirect("Inventory");
        }
      }
    }
  }
}

