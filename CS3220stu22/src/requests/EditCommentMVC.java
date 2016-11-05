package requests;

import models.GuestBookEntryMVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MVC/EditComment")
@SuppressWarnings("unchecked")
public class EditCommentMVC extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id;

    try {
      id = Integer.parseInt(request.getParameter("id"));
    } catch (Exception e) {
      response.sendRedirect("GuestBook");
      return;
    }

    List<GuestBookEntryMVC> entries = (List<GuestBookEntryMVC>) getServletContext().getAttribute("entries");

    for (GuestBookEntryMVC entry : entries) {
      if (entry.getId() == id) {
        request.setAttribute("entry", entry);
        break;
      }
    }

    request.getRequestDispatcher("/WEB-INF/EditComment.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    boolean hasError = false;

    String name = request.getParameter("name");
    if (name == null || name.trim().length() == 0) {
      request.setAttribute("nameError", "Please specify a name");
      hasError = true;
    }

    String message = request.getParameter("message");
    if (message == null || message.trim().length() == 0) {
      request.setAttribute("messageError", "Please specify a message");
      hasError = true;
    }

    int id;

    try {
      id = Integer.parseInt(request.getParameter("id"));
    } catch (Exception e) {
      response.sendRedirect("GuestBook");
      return;
    }

    if (hasError) {
      doGet(request, response);
      return;
    } else {
      List<GuestBookEntryMVC> entries = (List<GuestBookEntryMVC>) getServletContext().getAttribute("entries");

      for (GuestBookEntryMVC entry : entries) {
        if (entry.getId() == id) {
          entry.setName(name);
          entry.setMessage(message);
          break;
        }
      }
    }

    response.sendRedirect("GuestBook");
  }
}









