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

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    // Read values if they exist
    // Attendance
    String possibleAttendance = request.getParameter("possible-attendance") == null ? "" : request.getParameter("possible-attendance");
    String actualAttendance = request.getParameter("attendance") == null ? "" : request.getParameter("attendance");

    // Homework and Labs
    String possibleHwl = request.getParameter("possible-hwl") == null ? "" : request.getParameter("possible-hwl");
    String actualHwl = request.getParameter("hwl") == null ? "" : request.getParameter("hwl");

    // Quizzes
    String possibleQuizzes = request.getParameter("possible-quizzes") == null ? "" : request.getParameter("possible-quizzes");
    String actualQuizzes = request.getParameter("quizzes") == null ? "" : request.getParameter("quizzes");

    // Midterm
    String possibleMidterm = request.getParameter("possible-midterm") == null ? "" : request.getParameter("possible-midterm");
    String actualMidterm = request.getParameter("midterm") == null ? "" : request.getParameter("midterm");

    // Final
    String possibleFinal = request.getParameter("possible-final") == null ? "" : request.getParameter("possible-final");
    String actualFinal = request.getParameter("final") == null ? "" : request.getParameter("final");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("	<meta charset=\"UTF-8\">");
    out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
    out.println("	<title>Grade Calculator</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<div class=\"page-header\">");
    out.println("<h1>Grade Calculator</h1>");
    out.println("</div>");

    out.println("<form action=\"GradeCalculator\" method=\"post\">");
    out.println("<table class=\"table table-striped table-bordered table-hover\">");
    out.println("<tr>");
    out.println("<th>Category</th>");
    out.println("<th>Possible</th>");
    out.println("<th>Actual Score</th>");
    out.println("<th>Percent</th>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Attendance</td>");
    out.println("<td><input type=\"text\" name=\"possible-attendance\" placeholder=\"100\" value=\"" + 100 + "\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance\" value=\"" + 100 + "\"></td>");
    out.println("<td>-/5%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Homework and Lab</td>");
    out.println("<td><input type=\"text\" name=\"possible-hwl\" placeholder=\"210\" value=\"" + 210 + "\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl\" value=\"" + 210 + "\"></td>");
    out.println("<td>-/20%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Quizzes</td>");
    out.println("<td><input type=\"text\" name=\"possible-quizzes\" placeholder=\"50\" value=\"" + 50 + "\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes\" value=\"" + 35 + "\"></td>");
    out.println("<td>-/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Midterm</td>");
    out.println("<td><input type=\"text\" name=\"possible-midterm\" placeholder=\"100\" value=\"" + 100 + "\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm\" value=\"" + 85 + "\"></td>");
    out.println("<td>-/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Final</td>");
    out.println("<td><input type=\"text\" name=\"possible-final\" placeholder=\"100\" value=\"" + 100 + "\"></td>");
    out.println("<td><input type=\"text\" name=\"final\" value=\"" + 80 + "\"></td>");
    out.println("<td>-/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Total</td>");
    out.println("<td/>");
    out.println("<td><input type=\"submit\" class=\"btn btn-primary\" name=\"calculate\" value=\"Calculate\" /></td>");
    out.println("<td>-/100%</td>");
    out.println("</tr");

    out.println("</table>");
    out.println("</form");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Attendance
    String possibleAttendance = request.getParameter("possible-attendance");
    String actualAttendance = request.getParameter("attendance");

    // Homework and Labs
    String possibleHwl = request.getParameter("possible-hwl");
    String actualHwl = request.getParameter("hwl");

    // Quizzes
    String possibleQuizzes = request.getParameter("possible-quizzes");
    String actualQuizzes = request.getParameter("quizzes");

    // Midterm
    String possibleMidterm = request.getParameter("possible-midterm");
    String actualMidterm = request.getParameter("midterm");

    // Final
    String possibleFinal = request.getParameter("possible-final");
    String actualFinal = request.getParameter("final");

    double attendanceCalculation = 0;
    double hwlCalculation = 0;
    double quizzesCalculation = 0;
    double midtermCalculation = 0;
    double finalCalculation = 0;
    double totalCalculation;

    if (possibleAttendance == null || actualAttendance == null || possibleHwl == null || actualHwl == null || possibleQuizzes == null || actualQuizzes == null || possibleMidterm == null || actualMidterm == null || possibleFinal == null || actualFinal == null) {
      doGet(request, response);
      return;
    }

    try {
      attendanceCalculation = ((Double.parseDouble(request.getParameter("attendance")) / Double.parseDouble(request.getParameter("possible-attendance")) * .05) * 100);
      hwlCalculation = ((Double.parseDouble(request.getParameter("hwl")) / Double.parseDouble(request.getParameter("possible-hwl"))) * .2) * 100;
      quizzesCalculation = ((Double.parseDouble(request.getParameter("quizzes")) / Double.parseDouble(request.getParameter("possible-quizzes"))) * .25) * 100;
      midtermCalculation = ((Double.parseDouble(request.getParameter("midterm")) / Double.parseDouble(request.getParameter("possible-midterm")) * .25) * 100);
      finalCalculation = ((Double.parseDouble(request.getParameter("final")) / Double.parseDouble(request.getParameter("possible-final")) * .25) * 100);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    totalCalculation = attendanceCalculation + hwlCalculation + quizzesCalculation + midtermCalculation + finalCalculation;

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("	<!-- Latest compiled and minified CSS -->");
    out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
    out.println("	<meta charset=\"UTF-8\">");
    out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
    out.println("	<title>Grade Calculator</title>");
    out.println("</head>");

    out.println("<body>");
    out.println("<div class=\"container\">");
    out.println("<div class=\"page-header\">");
    out.println("<h1>Grade Calculator</h1>");
    out.println("</div>");

    out.println("<form action=\"GradeCalculator\" method=\"post\">");
    out.println("<table class=\"table table-striped table-bordered table-hover\">");
    out.println("<tr>");
    out.println("<th>Category</th>");
    out.println("<th>Possible</th>");
    out.println("<th>Actual Score</th>");
    out.println("<th>Percent</th>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Attendance</td>");
    out.println("<td><input type=\"text\" name=\"possible-attendance\" placeholder=\"100\" value=\"" + possibleAttendance + "\"></td>");
    out.println("<td><input type=\"text\" name=\"attendance\" value=\"" + actualAttendance + "\"></td>");
    out.println("<td>" + String.format("%.2f", attendanceCalculation) + "/5%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Homework and Lab</td>");
    out.println("<td><input type=\"text\" name=\"possible-hwl\" placeholder=\"210\" value=\"" + possibleHwl + "\"></td>");
    out.println("<td><input type=\"text\" name=\"hwl\" value=\"" + actualHwl + "\"></td>");
    out.println("<td>" + String.format("%.2f", hwlCalculation) + "/20%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Quizzes</td>");
    out.println("<td><input type=\"text\" name=\"possible-quizzes\" placeholder=\"50\" value=\"" + possibleQuizzes + "\"></td>");
    out.println("<td><input type=\"text\" name=\"quizzes\" value=\"" + actualQuizzes + "\"></td>");
    out.println("<td>" + String.format("%.2f", quizzesCalculation) + "/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Midterm</td>");
    out.println("<td><input type=\"text\" name=\"possible-midterm\" placeholder=\"100\" value=\"" + possibleMidterm + "\"></td>");
    out.println("<td><input type=\"text\" name=\"midterm\" value=\"" + actualMidterm + "\"></td>");
    out.println("<td>" + String.format("%.2f", midtermCalculation) + "/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Final</td>");
    out.println("<td><input type=\"text\" name=\"possible-final\" placeholder=\"100\" value=\"" + possibleFinal + "\"></td>");
    out.println("<td><input type=\"text\" name=\"final\" value=\"" + actualFinal + "\"></td>");
    out.println("<td>" + String.format("%.2f", finalCalculation) + "/25%</td>");
    out.println("</tr>");

    out.println("<tr>");
    out.println("<td>Total</td>");
    out.println("<td/>");
    out.println("<td><input type=\"submit\" class=\"btn btn-primary\" name=\"calculate\" value=\"Calculate\" /></td>");
    out.println("<td>" + String.format("%.2f", totalCalculation) + "/100%</td>");
    out.println("</tr");

    out.println("</table>");
    out.println("</form");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }
}
