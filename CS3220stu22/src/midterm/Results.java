package midterm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Midterm/Results")
public class Results extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    String name = (String) getServletContext().getAttribute("name");
    int score = (int) getServletContext().getAttribute("score");

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "\t<meta charset=\"utf-8\">\n" +
        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "\t<title>Results</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header text-center\">\n" +
        "\t\t<h1>Results</h1>\n" +
        "\t\t<h3 class=\"text-right\">" + name + "</a></h3>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"form-horizontal\">\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Name</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<p class=\"form-control-static\">" + name + "</p>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<label class=\"col-sm-2 control-label\">Score</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<p class=\"form-control-static\">" + score + "</p>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t\t<div class=\"form-group\">\n" +
        "\t\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n" +
        "\t\t\t\t<a href=\"Math\" class=\"btn btn-default\">Take Exam Again</a>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t</form>\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
