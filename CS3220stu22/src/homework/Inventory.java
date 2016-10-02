package homework;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/store/Inventory", loadOnStartup = 1)
public class Inventory extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) throws ServletException {

    super.init(config);

    ArrayList<Item> inventory = new ArrayList<>();

    inventory.add(new Item("qwe", ";lte3", 123, 456));
    inventory.add(new Item("abc", "los Angeles", 123, 456));

    getServletContext().setAttribute("inventory", inventory);
  }

  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ServletContext context = this.getServletContext();

    List<Item> inventory = (List<Item>) context.getAttribute("inventory");

    if (inventory.isEmpty()) {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("\t<meta charset=\"utf-8\">");
      out.println("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

      out.println("\t<title>Store Inventory</title>");

      out.println("<!-- Latest compiled and minified CSS -->\n" +
          "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
          "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
      out.println("</head>");

      out.println("<body>");

      out.println("<div class=\"container\">\n" +
          "<div class=\"page-header text-center\">\n" +
          "<h1>Inventory</h1>\n" +
          "</div>");

      out.println("<h2 class=\"text-center\">");
      out.println("There are no items in your inventory!");
      out.println("</h2>");

      out.println("<br/>");

      out.println("<h3 class=\"text-center\"><a style=\"text-decoration: none\" href=\"AddItem\">Add Item</a></h3>");

      out.println("</body>");
    } else {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("\t<meta charset=\"utf-8\">");
      out.println("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");

      out.println("\t<title>Store Inventory</title>");

      out.println("<!-- Latest compiled and minified CSS -->\n" +
          "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
          "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
      out.println("</head>");

      out.println("<body>");

      out.println("<div class=\"container\">\n" +
          "\t<div class=\"page-header\">\n" +
          "\t\t<h1>Inventory</h1>\n" +
          "\t</div>");

      out.println("<form class=\"text-center\" action=\"Inventory\" method=\"get\">\n" +
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
          "\t\t</tr>\n");

      for (Item item : inventory) {

        String query = request.getParameter("query");

        if (query == null || item.getName().toLowerCase().contains(query.trim()) || item.getDescription().toLowerCase().contains(query.trim())) {
          out.println("\t\t<tr>");
          out.println("\t\t\t<td>" + item.getName() + "</td>");
          out.println("\t\t\t<td>" + item.getDescription() + "</td>");
          out.println("\t\t\t<td>" + item.getQuantity() + "</td>");
          out.println("\t\t\t<td>" + item.getPrice() + "</td>");
          out.println("\t\t\t<td><a href=\"DeleteEntry?id=" + item.getId() + "\">Delete</a>");
        }
      }

      out.println("\t</table>");

      out.println("<a class=\"btn btn-primary\" href=\"AddItem\">Add Item</a>");

      out.println("</body>");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}