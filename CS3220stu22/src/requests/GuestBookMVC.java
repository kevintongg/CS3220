package requests;

import models.GuestBookEntryMVC;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MVC/GuestBook")
public class GuestBookMVC extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    List<GuestBookEntryMVC> entries = new ArrayList<>();

    entries.add(new GuestBookEntryMVC("John Doe", "Hello"));
    entries.add(new GuestBookEntryMVC("Mary", "Hi"));

    getServletContext().setAttribute("entries", entries);
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/GuestBook.jsp");
    dispatcher.forward(request, response);
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
