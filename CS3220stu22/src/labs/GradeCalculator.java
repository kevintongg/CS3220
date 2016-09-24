package labs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/labs/GradeCalculator")
public class GradeCalculator extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String error = (String) request.getAttribute("error");



    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("	<meta charset=\"UTF-8\">");
    out.println("	<title>Grade Calculator</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<div class=\"page-header\">");
    out.println("<h1>Grade Calclulator</h1>");
    out.println("</div>");

    out.println("<form action=\"GradeCalculator\" method=\"post\">");
    out.println("<table class=\"table table-hover\">");
    out.println("<tr>");
    out.println("<th>Category</th>");
    out.println("<th>Possible</th>");
    out.println("<th>My Score</th>");
    out.println("<th>Percent</th>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Attendance</td>");
    out.println("<td><input type=\"text\" name=\"possible-attendance\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance_percent\" placeholder=\"/5%\"></td>");
    out.println("</tr");

    out.println("<tr>");
    out.println("<td>Homework and Labs</td>");
    out.println("<td><input type=\"text\" name=\"possible-hwl\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl-percent\" placeholder=\"/20%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Quizzes</td>");
    out.println("<td><input type=\"text\" name=\"possible-quizzes\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Midterm</td>");
    out.println("<td><input type=\"text\" name=\"possible-midterm\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Final</td>");
    out.println("<td><input type=\"text\" name=\"possible-final\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"final\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"final-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Total</td>");
    out.println("<td/>");
    out.println("<td><input type=\"submit\" class=\"btn btn-primary\" name=\"calculate\" value=\"Calculate\" /></td>");
    out.println("<td><input type=\"text\" name=\"total-percent\" placeholder=\"-/100%\"></td>");
    out.println("</tr");

    out.println("</table>");
    out.println("</form");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");


  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("	<meta charset=\"UTF-8\">");
    out.println("	<title>Grade Calculator</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<div class=\"page-header\">");
    out.println("<h1>Grade Calclulator</h1>");
    out.println("</div>");

    out.println("<form action=\"GradeCalculator\" method=\"post\">");
    out.println("<table class=\"table table-hover\">");
    out.println("<tr>");
    out.println("<th>Category</th>");
    out.println("<th>Possible</th>");
    out.println("<th>My Score</th>");
    out.println("<th>Percent</th>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Attendance</td>");
    out.println("<td><input type=\"text\" name=\"possible-attendance\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance_percent\" placeholder=\"/5%\"></td>");
    out.println("</tr");

    out.println("<tr>");
    out.println("<td>Homework and Labs</td>");
    out.println("<td><input type=\"text\" name=\"possible-hwl\" placeholder=\"110\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl-percent\" placeholder=\"/20%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Quizzes</td>");
    out.println("<td><input type=\"text\" name=\"possible-quizzes\" placeholder=\"50\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Midterm</td>");
    out.println("<td><input type=\"text\" name=\"possible-midterm\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Final</td>");
    out.println("<td><input type=\"text\" name=\"possible-final\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"final\" placeholder=\"100\"></td>");
    out.println("<td><input type=\"text\" name=\"final-percent\" placeholder=\"/25%\"></td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Total</td>");
    out.println("<td/>");
    out.println("<td><input type=\"submit\" class=\"btn btn-primary\" name=\"calculate\" value=\"Calculate\" /></td>");
    out.println("<td><input type=\"text\" name=\"total-percent\" placeholder=\"-/100%\"></td>");
    out.println("</tr");

    out.println("</table>");
    out.println("</form");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }

}
