package midterm;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Midterm/Education")
public class Education extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    String name = request.getParameter("name") == null || request.getAttribute("nameError") != null ? "" : request.getParameter("name");

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "\t<meta charset=\"utf-8\">\n" +
        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "\t<title>Education Helper</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n");

    out.println("<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Enter Name</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"form-horizontal\" method=\"post\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Name:</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"name\" placeholder=\"Name\" value=\"" + name + "\" autofocus>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n" +
        "\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t</form>\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>");

    out.println("</div>\n" +
        "</body>\n" +
        "</html>");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");

    if (name == null || name.trim().length() == 0) {
      getServletContext().setAttribute("name", "Friend");
    } else {
      getServletContext().setAttribute("name", name);
    }

    response.sendRedirect("Math");

  }
}
