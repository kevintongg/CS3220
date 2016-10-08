package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Store/AddUser")
public class AddUser extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    String fullName = request.getParameter("fullName") == null || request.getAttribute("nameError") != null ? "" : request.getParameter("fullName");
    String email = request.getParameter("email") == null || request.getAttribute("email") != null ? "" : request.getParameter("email");

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "\t<meta charset=\"utf-8\">\n" +
        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "\t<title>Add User</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Add User</h1>\n" +
        "\t</div>");

    out.println("\t<form class=\"form-horizontal\" method=\"post\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Full Name:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"fullName\" placeholder=\"Full Name\" value=\"" + fullName + "\" autofocus>\n");
    if (request.getAttribute("nameError") != null) {
      out.println("\t\t\t<label style=\"color: red\">Please enter your full name!</label>\n");
    }
    out.println("\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Email Address:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"email\" placeholder=\"Email\" value=\"" + email + "\">\n");
    if (request.getAttribute("emailError") != null) {
      out.println("\t\t\t<label style=\"color: red\">Please enter a valid email address!</label>");
    }
    out.println("\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Password:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"password\" name=\"pw1\" placeholder=\"Password\">\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Input Password Again:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"password\" name=\"pw2\" placeholder=\"Re-enter your password\">\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<button class=\"btn btn-primary\" type=\"submit\">Add User</button>\n" +
        "\t</form>\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>");
  }

  @Override
  @SuppressWarnings("unchecked")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    boolean hasError = false; // Assume that we start with no errors

    // Validate the name
    String fullName = request.getParameter("fullName");
    String firstName = null;
    String lastName = null;

    if (fullName != null) {
      // Tokenize the fullName
      String[] tokens = fullName.trim().split(" ");

      // Did the User submit at least two names?
      if (tokens.length < 2) {
        hasError = true;
        request.setAttribute("nameError", true);
      } else {
        firstName = tokens[0];
        lastName = tokens[1];
      }
    } else {
      hasError = true;
      request.setAttribute("nameError", true);
    }

    // Validate the e-mail
    String email = request.getParameter("email");

    if (email == null || email.trim().length() == 0) {
      hasError = true;
      request.setAttribute("emailError", true);
    }

    // Validate password
    String pw1 = request.getParameter("pw1");
    String pw2 = request.getParameter("pw2");

    if (pw1 == null || pw2 == null || pw1.trim().length() == 0 || !pw1.equals(pw2)) {
      hasError = true;
      request.setAttribute("passwordError", true);
    }

    // Redisplay the form if we have errors
    if (hasError) {
      doGet(request, response);
    } else {
      // Cool, let's add a new user
      List<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
      users.add(new User(firstName, lastName, email, pw1));
      response.sendRedirect("AllUsers");
    }
  }
}
