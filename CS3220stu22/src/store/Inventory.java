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

@WebServlet("/store/Inventory")
public class Inventory extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    List<Item> inventory = new ArrayList<>();
    getServletContext().setAttribute("inventory", inventory);
  }

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
        "\t<title>Inventory</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "\t<meta charset=\"utf-8\"/>\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Inventory</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form class=\"text-center\" action=\"Inventory\" method=\"get\">\n" +
        "\t\t<input class=\"text-center\" type=\"text\" placeholder=\"Search Items\" name=\"query\">\n" +
        "\t\t<input type=\"submit\" value=\"Search\">\n" +
        "\t</form>\n" +
        "\n" +
        "\t<br/>\n" +
        "\n" +
        "\t<table class=\"table table-striped table-bordered table-hover text\" border=\"1\">\n" +
        "\t\t<tr>\n" +
        "\t\t\t<th>Name</th>\n" +
        "\t\t\t<th>Description</th>\n" +
        "\t\t\t<th>Quantity</th>\n" +
        "\t\t\t<th>Price</th>\n" +
        "\t\t\t<th>Actions</th>\n" +
        "\t\t</tr>\n" +
        "\t</table>\n" +
        "\n" +
        "\t<h4><a style=\"text-decoration: none\" href=\"Inventory\">Add Item</a></h4>\n" +
        "</div>\n" +
        "</body>\n" +
        "</html>\n");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
