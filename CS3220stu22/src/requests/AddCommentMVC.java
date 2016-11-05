package requests;

import models.GuestBookEntryMVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MVC/AddComment")
public class AddCommentMVC extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    request.getRequestDispatcher("/WEB-INF/AddComment.jsp").forward(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String name = request.getParameter("name");
    String message = request.getParameter("message");

    // Check the values of name and message
    if (name == null || name.trim().length() == 0 ||
        message == null || message.trim().length() == 0) {

      doGet(request, response);
    } else {
      List<GuestBookEntryMVC> entries = (List<GuestBookEntryMVC>) getServletContext().getAttribute("entries");
      entries.add(new GuestBookEntryMVC(name, message));

      response.sendRedirect("GuestBook");
    }
  }
}








