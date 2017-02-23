package intro;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Intro/SimplePageCounter")
public class PageCounter extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private int counter = 0;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Set the content type to HTML
    response.setContentType("text/html");

    // Get a reference to a print writer that writes back to the browser
    PrintWriter out = response.getWriter();

    // Print our message
    out.println("<h1>You are visitor: " + ++counter + "</h1>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}