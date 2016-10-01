package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/store/AddItem")
public class AddItem extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name") == null ? "" : request.getParameter("name");
    String description = request.getParameter("description") == null ? "" : request.getParameter("description");
    String quantity = request.getParameter("quantity") == null ? "" : request.getParameter("quantity");
    String price = request.getParameter("price") == null ? "" : request.getParameter("price");


    String nameError = (String) request.getAttribute("name-error");
    String descriptionError = (String) request.getAttribute("description-error");
    String quantityError = (String) request.getAttribute("quantity-error");
    String priceError = (String) request.getAttribute("price-error");


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
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Add Item</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form action=\"AddItem\" method=\"post\">\n" +
        "\t\t<table class=\"table table-striped table-bordered table-hover text\" border=\"1\">\n" +
        "\t\t\t<tr>\n" +
        "\t\t\t\t<th>Name</th>\n" +
        "\t\t\t\t<th>Description</th>\n" +
        "\t\t\t\t<th>Quantity</th>\n" +
        "\t\t\t\t<th>Price</th>\n" +
        "\t\t\t</tr>\n" +
        "\n" +
        "\t\t\t<tr>\n");
    if (nameError != null) {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"name\" placeholder=\"Name\" value=\">" + "<h5 style=\"color: red\">" + quantityError + "</h5>" + "</td>\n");
    } else {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"name\" placeholder=\"Name\" value=\"" + name + "\"></td>\n");
    }

    if (descriptionError != null) {
      out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\"></textarea><h5 style=\"color: red\">" + descriptionError + "</h5>" + "</td>\n");
    } else {
      out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\">" + description + "</textarea></td>\n");
    }
    if (quantityError != null) {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\">" + "<h5 style=\"color: red\">" + quantityError + "</h5>" + "</td>\n");
    } else {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\" value=\"" + quantity + "\"></td>\n");
    }

    if (priceError != null) {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\">" + priceError + "</td>\n");
    } else {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\" value=\"" + price + "\"></td>\n");
    }

    out.println("\t\t\t</tr>\n" +
        "\t\t</table>\n" +
        "\n" +
        "\t\t<input class=\"btn btn-primary\" type=\"submit\" value=\"Add Item\">\n" +
        "\t</form>\n" +
        "</div>");

    out.println("</body>");
    out.println("</html>");

  }

  @SuppressWarnings("unchecked")
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String quantity = request.getParameter("quantity");
    String price = request.getParameter("price");

    String nameError = (String) request.getAttribute("name-error");
    String descriptionError = (String) request.getAttribute("description-error");
    String quantityError = (String) request.getAttribute("quantity-error");
    String priceError = (String) request.getAttribute("price-error");

    int quantityAsInt;
    double priceAsDouble;

    if (request.getParameter("name") == null || request.getParameter("description") == null || request.getParameter("quantity") == null || request.getParameter("price") == null) {
      doGet(request, response);
      return;
    }

    if (request.getParameter("name").isEmpty() || request.getParameter("name") == null) {
      request.setAttribute("name-error", "Please enter a valid name!");
    }

    if (!request.getParameter("name").isEmpty() && name.trim().length() > 0 && !request.getParameter("description").isEmpty() && description.trim().length() > 0 && !quantity.matches("\\D") && quantity.trim().length() > 0 && !price.matches("\\D") && price.trim().length() > 0) {
      try {
        quantityAsInt = Integer.parseInt(request.getParameter("quantity"));
        priceAsDouble = Double.parseDouble(request.getParameter("price"));

        List<Item> list = (List<Item>) request.getServletContext().getAttribute("inventory");

        list.add(new Item(name, description, quantityAsInt, priceAsDouble));

        response.sendRedirect("Inventory");

      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    }

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
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Add Item</h1>\n" +
        "\t</div>\n" +
        "\n" +
        "\t<form action=\"AddItem\" method=\"post\">\n" +
        "\t\t<table class=\"table table-striped table-bordered table-hover text\" border=\"1\">\n" +
        "\t\t\t<tr>\n" +
        "\t\t\t\t<th>Name</th>\n" +
        "\t\t\t\t<th>Description</th>\n" +
        "\t\t\t\t<th>Quantity</th>\n" +
        "\t\t\t\t<th>Price</th>\n" +
        "\t\t\t</tr>\n" +
        "\n" +
        "\t\t\t<tr>\n");
    if (request.getParameter("name") != null) {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"name\" placeholder=\"Name\" value=\"" + name + "\"></td>\n");
    } else {
      if (request.getParameter("name").isEmpty() || request.getParameter("name") == null) {
        request.setAttribute("name-error", "Please enter a valid name!");
      }
      out.println("\t\t\t\t<td><input type=\"text\" name=\"name\" placeholder=\"Name\">" + "<h5 style=\"color: red\">" + nameError + "</td>\n");
    }

    if (request.getParameter("description") != null) {
      out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\">" + description + "</textarea></td>\n");
    } else if (request.getParameter("description").contains("")) {
//      request.setAttribute("description-error", "Please enter a valid description!");
      out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\"></textarea>" + "<h5 style=\"color : red\">Please enter a valid description!</h5></td>\n");
    }
//      out.println("\t\t\t\t<td><textarea name=\"description\" placeholder=\"Description\" rows=\"1\"></textarea>" + "<h5 style=\"color : red\">" + descriptionError + "</td>\n");
//    }
    if (request.getParameter("quantity") != null) {
      try {
        quantityAsInt = Integer.parseInt(request.getParameter("quantity"));
        out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\" value=\"" + quantityAsInt + "\"></td>\n");
      } catch (NumberFormatException e) {
        out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\">" + "<h5 style=\"color: red\">Please enter a valid quantity!</h5>" + "</td>\n");
      }
    } else {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"quantity\" placeholder=\"Quantity\"></td>\n");
    }

    if (request.getParameter("price") != null) {
      try {
        priceAsDouble = Double.parseDouble(request.getParameter("price"));
        out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\" value=\"" + String.format("%.2f", priceAsDouble) + "\"></td>\n");
      } catch (NumberFormatException e) {
        out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\"><h5 style=\"color: red\">Please enter a valid price!</h5></td>\n");
      }
    } else {
      out.println("\t\t\t\t<td><input type=\"text\" name=\"price\" placeholder=\"Price\"></td>\n");
    }

    out.println("\t\t\t</tr>\n" +
        "\t\t</table>\n" +
        "\n" +
        "\t\t<input class=\"btn btn-primary\" type=\"submit\" value=\"Add Item\">\n" +
        "\t</form>\n" +
        "</div>");

    out.println("</body>");
    out.println("</html>");

  }
}
