package homework;

import javax.servlet.ServletConfig;
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

    users.add(new User("test", "asdf"));

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

    out.println("<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Login</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"form-inline\" method=\"post\">\n");

    out.println("</body>\n" +
        "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();

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
    if (email == null || email.trim().length() == 0) {
      hasError = true;
      request.setAttribute("emailError", true);
    }

    String password = request.getParameter("password");

    if (password == null || password.trim().length() == 0) {
      hasError = true;
      request.setAttribute("passwordError", true);
    }

    if (hasError) {
      doGet(request, response);
      return;
    } else {

    }
  }
}
