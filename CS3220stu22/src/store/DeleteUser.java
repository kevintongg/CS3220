package store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Store/DeleteUser")
@SuppressWarnings("unchecked")
public class DeleteUser extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("id"));

    List<User> users = (List<User>) getServletContext().getAttribute("users");

    for (User user : users) {
      if (user.getId() == id) {
        users.remove(user);
        break;
      }
    }

    response.sendRedirect("AllUsers");

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
