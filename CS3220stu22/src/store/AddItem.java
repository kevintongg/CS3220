package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/Store/AddItem")
public class AddItem extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name") == null || request.getAttribute("nameError") != null ? "" : request.getParameter("name");
    String description = request.getParameter("description") == null || request.getAttribute("descriptionError") != null ? "" : request.getParameter("description");
    String quantity = request.getParameter("quantity") == null || request.getAttribute("quantityError") != null ? "" : request.getParameter("quantity");
    String price = request.getParameter("price") == null || request.getAttribute("priceError") != null ? "" : request.getParameter("price");


    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("<title>Add Item</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<div class=\"container\">\n" +
        "\t<div class=\"page-header text-center\">\n" +
        "\t\t<h1>Add Item</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form action=\"AddItem\" method=\"post\">\n" +
        "\t\t<table class=\"table table-striped table-bordered table-hover text-center\" border=\"1\">\n" +
        "\t\t\t<tr>\n" +
        "\t\t\t\t<th class=\"text-center\">Name</th>\n" +
        "\t\t\t\t<th class=\"text-center\">Description</th>\n" +
        "\t\t\t\t<th class=\"text-center\">Quantity</th>\n" +
        "\t\t\t\t<th class=\"text-center\">Price</th>\n" +
        "\t\t\t\t<th class=\"text-center\">Action</th>" +
        "\t\t\t</tr>\n" +
        "\n" +
        "\t\t\t<tr>\n");

    out.println("\t\t\t\t<td><input type=\"text\" name=\"name\" placeholder=\"Name\" value=\"" + name + "\">");
    if (request.getAttribute("nameError") != null) {
      out.println("<h5 style=\"color: red\">Please enter a valid name!</h5>");
    }
    out.println("</td>\n");
    out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\">" + description + "</textarea>");
    if (request.getAttribute("descriptionError") != null) {
      out.println("<h5 style=\"color: red\">Please enter a valid description!</h5>");
    }
    out.println("</td>\n");
    out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\" value=\"" + quantity + "\">");
    if (request.getAttribute("quantityError") != null) {
      out.println("<h5 style=\"color: red\">Please enter a valid quantity!</h5>");
    }
    out.println("</td>\n");
    out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\" value=\"" + price + "\">");
    if (request.getAttribute("priceError") != null) {
      out.println("<h5 style=\"color: red\">Please enter a valid price!</h5>");
    }
    out.println("</td>\n");

    out.println("\t\t\t\t<td><input class=\"btn btn-primary\" type=\"submit\" value=\"Add Item\"></td>");

    out.println("\t\t\t</tr>\n" +
        "\t\t</table>\n" +
        "\n" +
        "\t</form>\n" +
        "</div>");

    out.println("</body>");
    out.println("</html>");

  }

  @Override
  @SuppressWarnings("unchecked")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    boolean hasError = false;

    String name = request.getParameter("name");

    if (name == null || name.trim().length() == 0) {
      hasError = true;
      request.setAttribute("nameError", true);
    }

    String description = request.getParameter("description");

    if (description == null || description.trim().length() == 0) {
      hasError = true;
      request.setAttribute("descriptionError", true);
    }

    String quantity = request.getParameter("quantity");
    int quantityAsNum;

    try {
      quantityAsNum = Integer.parseInt(quantity);
    } catch (NumberFormatException e) {
      hasError = true;
      request.setAttribute("quantityError", true);
    }

    String price = request.getParameter("price");
    double priceAsNum;

    try {
      if (price != null) {
        priceAsNum = Double.parseDouble(price);
      }
    } catch (NumberFormatException e) {
      hasError = true;
      request.setAttribute("priceError", true);
    }

    if (hasError) {
      doGet(request, response);
      return;
    } else {
      try {
        quantityAsNum = Integer.parseInt(quantity);
        priceAsNum = Double.parseDouble(price);

        List<Item> items = (List<Item>) request.getServletContext().getAttribute("inventory");

        items.add(new Item(name, description, quantityAsNum, priceAsNum));

        response.sendRedirect("Inventory");
      } catch (NumberFormatException e) {
        out.format("NumberFormatException: %s%n", e);
      }
    }
  }
}
