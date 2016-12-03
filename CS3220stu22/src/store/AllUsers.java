package store;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Store/AllUsers", loadOnStartup = 1)
public class AllUsers extends HttpServlet {

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    // Create the collection in the servlet context to be used by all other servlets
    List<User> users = new ArrayList<>();

    // Pre-Populate your users database with the following accounts
    users.add(new User("John", "Doe", "john@doe.com", "aa"));
    users.add(new User("Mary", "Jane", "mary@jane.com", "bb"));
    users.add(new User("Joe", "Boxer", "joe@boxer.com", "cc"));
    users.add(new User("Kevin", "Tong", "kevin@tong.com", "asdf"));

    // Add the users list to the global scope
    getServletContext().setAttribute("users", users);

  }

  @Override
  @SuppressWarnings("unchecked")
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
        "\t<title>All Users</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>User finalExam</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"text-center\" action=\"AllUsers\" method=\"get\">\n" +
        "\t\t<input type=\"text\" name=\"query\">\n" +
        "\t\t<input type=\"submit\" value=\"Search\">\n" +
        "\t</form>\n" +
        "\t<br />\n" +
        "\t<table class=\"table table-striped table-bordered table-hover text-center\" border=\"1\">\n" +
        "\t\t<tr>\n" +
        "\t\t\t<th class=\"text-center\">ID</th>\n" +
        "\t\t\t<th class=\"text-center\">Name</th>\n" +
        "\t\t\t<th class=\"text-center\">Email Address</th>\n" +
        "\t\t\t<th class=\"text-center\">Password</th>\n" +
        "\t\t\t<th class=\"text-center\">Actions</th>\n" +
        "\t\t</tr>\n");

    List<User> users = (ArrayList<User>) getServletContext().getAttribute("users");

    for (User user : users) {

      String query = request.getParameter("query");

      if (query == null || user.getEmail().contains(query.trim())) {
        out.println("\t\t<tr>");
        out.println("\t\t\t<td>" + (user.getId() + 1) + "</td>");
        out.println("\t\t\t<td>" + user.getFirstName() + " " + user.getLastName() + "</td>");
        out.println("\t\t\t<td>" + user.getEmail() + "</td>");
        out.println("\t\t\t<td>" + user.getPassword() + "</td>");
        out.println("\t\t\t<td><a href=\"DeleteUser?id=" + user.getId() + "\">Delete</a>");
        out.println("\t\t</tr>");
      }
    }

    out.println("\t</table>\n" +
        "\t<a href=\"AddUser\" class=\"btn btn-default\">Add User</a>\n" +
        "\t<a href=\"Login\" class=\"btn btn-default\">Login</a>\n" +
        "\t<a href=\"Logout\" class=\"btn btn-default\">Logout</a>" +
        "</div>\n" +
        "</body>\n" +
        "</html>\n");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
