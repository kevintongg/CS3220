package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store/DeleteEntry")
@SuppressWarnings("unchecked")
public class DeleteEntry extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    List<Item> inventory = (List<Item>) getServletContext().getAttribute("inventory");

    for (Item item : inventory) {
      if (item.getId() == id) {
        inventory.remove(item);
        break;
      }
    }

    response.sendRedirect("Inventory");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
