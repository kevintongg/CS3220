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
  public void init(ServletConfig config) throws ServletException {

    super.init(config);

    List<User> users = new ArrayList<>();

    users.add(new User("john@doe.com", "aa"));
    users.add(new User("mary@jane.com", "bb"));
    users.add(new User("joe@boxer.com", "cc"));
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

    String emailCookie = getEmail(request);

    out.println("<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Login</h1>\n" +
        "\t</div>\n" +
        "\n");

    if (request.getAttribute("emailError") != null || request.getAttribute("passwordError") != null) {
      out.println("\t<h5 style=\"color: red\">Invalid/Incorrect password! Please try again!</h5>\n");
    }

    out.println("\t<form class=\"form-inline\" method=\"post\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email\" value=\"" + email + emailCookie + "\">\n" +
        "\t\t</div>\n" +
        "<br />" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" value=\"" + password + "\">\n");
    out.println("\t\t<br />");
    out.println("\t\t<br />\n");
    out.println("\t\t</div>\n" +
        "\t\t<br />\n" +
        "\t\t<div class=\"checkbox\">\n" +
        "\t\t\t<label>\n" +
        "\t\t\t\t<input type=\"checkbox\" name=\"rememberMe\"> Remember me\n" +
        "\t\t\t</label>\n" +
        "\t\t</div>\n" +
        "\t\t<br />\n" +
        "\t\t<br />\n" +
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

    boolean emailError = false;
    boolean passwordError = false;

    String email = request.getParameter("email");
    String password = request.getParameter("password");
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

    for (User user : users) {
      if (email == null || user.getEmail().trim().length() == 0) {
        emailError = true;
        request.setAttribute("emailError", true);
      } else if (!user.getEmail().equals(email)) {
        emailError = true;
        request.setAttribute("emailError", true);
      } else if (user.getEmail().equals(email)) {
        emailError = false;
        request.setAttribute("emailError", false);
      }
    }

    for (User user : users) {
      if (password == null || user.getPassword().trim().length() == 0) {
        passwordError = true;
        request.setAttribute("passwordError", true);
      } else if (!user.getPassword().equals(password)) {
        passwordError = true;
        request.setAttribute("passwordError", true);
      } else if (user.getPassword().equals(password)) {
        passwordError = false;
        request.setAttribute("passwordError", false);
      }
    }

    if (emailError || passwordError) {
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

