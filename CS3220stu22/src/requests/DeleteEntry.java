package requests;

import models.GuestBookEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/requests/DeleteEntry")
@SuppressWarnings("unchecked")
public class DeleteEntry extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Get the id of the element to be deleted
    int id = Integer.parseInt(request.getParameter("id"));

    // Get a reference to our guest book
    List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");

    // Remove the element with the specified id
    for (GuestBookEntry entry : entries) {
      if (entry.getId() == id) {
        entries.remove(entry);
        break;
      }
    }

    // Send the user back to the Guest Book page
    response.sendRedirect("GuestBook");

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}