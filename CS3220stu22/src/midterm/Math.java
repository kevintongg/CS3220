package midterm;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/Midterm/Math")
@SuppressWarnings("")
public class Math extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    List<Problem> problems = new ArrayList<>();

    problems.add(new Problem(1, 1));
    problems.add(new Problem(2, 2));
    problems.add(new Problem(3, 3));
    problems.add(new Problem(12, 2));
    problems.add(new Problem(8, 4));
    problems.add(new Problem(10, 2));
    problems.add(new Problem(6, 2));
    problems.add(new Problem(20, 2));
    problems.add(new Problem(20, 10));

    getServletContext().setAttribute("problems", problems);

  }

  @Override
  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    List<Problem> problems = (ArrayList<Problem>) getServletContext().getAttribute("problems");

    String addition = request.getParameter("additionAnswer") == null ? "" : request.getParameter("additionAnswer");
    String subtraction = request.getParameter("subtractionAnswer") == null ? "" : request.getParameter("subtractionAnswer");
    String multiplication = request.getParameter("multiplicationAnswer") == null ? "" : request.getParameter("multiplicationAnswer");
    String division = request.getParameter("divisionAnswer") == null ? "" : request.getParameter("divisionAnswer");

    out.println("<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "\t<meta charset=\"utf-8\">\n" +
        "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "\t<title>Math</title>\n" +
        "\n" +
        "\t<!-- Latest compiled and minified CSS -->\n" +
        "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\n" +
        "\t      integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
        "</head>\n" +
        "\n" +
        "<body>\n" +
        "<div class=\"container\">\n" +
        "\t<div class=\"page-header text-center\">\n" +
        "\t\t<h1>Math</h1>\n" +
        "\t\t<h3 class=\"text-right\">" + getServletContext().getAttribute("name") + "</a></h3>" +
        "\t</div>");

    out.println("\t<form class=\"form-horizontal\" method=\"post\">\n");

    out.println("\t\t<div class=\"form-group\">\n");

    int additionNum1 = 0;
    int additionNum2 = 0;
    int additionCounter = 0;

    boolean addNums = false;

    for (Problem p : problems) {
      Collections.shuffle(problems);
      additionNum1 = p.getNum1();
      additionNum2 = p.getNum2();
      Collections.shuffle(problems);
      additionCounter++;
      if (additionCounter == 2) {
        addNums = true;
        break;
      }
    }

    getServletContext().setAttribute("additionNum1", additionNum1);
    getServletContext().setAttribute("additionNum2", additionNum2);

    out.println("\t\t\t<label class=\"col-sm-2 control-label\">Addition: " + additionNum1 + " + " + additionNum2 + "</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"additionAnswer\" placeholder=\"Enter your answer\" value=\"" + addition + "\" autofocus>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>");

    int subtractionNum1 = 0;
    int subtractionNum2 = 0;
    int subtractionCounter = 0;

    for (Problem p : problems) {
      Collections.shuffle(problems);
      subtractionNum1 = p.getNum1();
      subtractionNum2 = p.getNum2();
      Collections.shuffle(problems);
      subtractionCounter++;
      if (subtractionCounter == 2) {
        break;
      }
    }

    getServletContext().setAttribute("subtractionNum1", subtractionNum2);
    getServletContext().setAttribute("subtractionNum2", subtractionNum2);

    out.println("\t<div class=\"form-group\">\n" +
        "\t<label class=\"col-sm-2 control-label\">Subtraction: " + subtractionNum1 + " - " + subtractionNum2 + "</label>\n" +
        "\t<div class=\"col-sm-10\">\n" +
        "\t\t<input class=\"form-control\" type=\"text\" name=\"subtractionAnswer\" placeholder=\"Enter your answer\" value=\"" + subtraction + "\">\n" +
        "\t</div>\n" +
        "\t</div>\n");

    int multiplicationNum1 = 0;
    int multiplicationNum2 = 0;
    int multiplicationCounter = 0;

    for (Problem p : problems) {
      Collections.shuffle(problems);
      multiplicationNum1 = p.getNum1();
      multiplicationNum2 = p.getNum2();
      Collections.shuffle(problems);
      multiplicationCounter++;
      if (multiplicationCounter == 2) {
        break;
      }
    }

    getServletContext().setAttribute("multiplicationNum1", multiplicationNum1);
    getServletContext().setAttribute("multiplicationNum2", multiplicationNum2);

    out.println("\t<div class=\"form-group\">\n" +
        "\t<label class=\"col-sm-2 control-label\">Multiplication: " + multiplicationNum1 + " x " + multiplicationNum2 + "</label>\n" +
        "\t<div class=\"col-sm-10\">\n" +
        "\t\t<input class=\"form-control\" type=\"text\" name=\"multiplicationAnswer\" placeholder=\"Enter your answer\" value=\"" + multiplication + "\">\n" +
        "\t</div>\n" +
        "\t</div>\n");

    int divisionNum1 = 0;
    int divisionNum2 = 0;
    int divisionCounter = 0;

    for (Problem p : problems) {
      Collections.shuffle(problems);
      divisionNum1 = p.getNum1();
      divisionNum2 = p.getNum2();
      Collections.shuffle(problems);
      divisionCounter++;
      if (divisionCounter == 2) {
        break;
      }
    }

    getServletContext().setAttribute("divisionNum1", divisionNum1);
    getServletContext().setAttribute("divisionNum2", divisionNum2);

    out.println("\t<div class=\"form-group\">\n" +
        "\t\t<label class=\"col-sm-2 control-label\">Division: " + divisionNum1 + " / " + divisionNum2 + "</label>\n" +
        "\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t<input class=\"form-control\" type=\"text\" name=\"divisionAnswer\" placeholder=\"Enter your answer\" value=\"" + division + "\">\n" +
        "\t\t</div>\n" +
        "\t</div>\n" +
        "\t<div class=\"form-group\">\n" +
        "\t\t\t<div class=\"col-sm-offset-2 col-sm-10\">\n" +
        "\t\t\t\t<button type=\"submit\" class=\"btn btn-default\">Submit</button>\n" +
        "\t\t\t</div>\n" +
        "\t\t</div>\n" +
        "\t</form>\n" +
        "\t</div>\n" +
        "</body>\n" +
        "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    boolean hasError = false;

    int additionNum1 = (int) getServletContext().getAttribute("additionNum1");
    int additionNum2 = (int) getServletContext().getAttribute("additionNum2");
    int subtractionNum1 = (int) getServletContext().getAttribute("subtractionNum1");
    int subtractionNum2 = (int) getServletContext().getAttribute("subtractionNum2");
    int multiplicationNum1 = (int) getServletContext().getAttribute("multiplicationNum1");
    int multiplicationNum2 = (int) getServletContext().getAttribute("multiplicationNum2");
    int divisionNum1 = (int) getServletContext().getAttribute("divisionNum1");
    int divisionNum2 = (int) getServletContext().getAttribute("divisionNum2");
    String additionResult = request.getParameter("additionAnswer");
    String subtractionResult = request.getParameter("subtractionAnswer");
    String multiplicationResult = request.getParameter("multiplicationAnswer");
    String divisionResult = request.getParameter("divisionAnswer");

    int addNum = additionNum1 + additionNum2;
    int subNum = subtractionNum1 - subtractionNum2;
    int multNum = multiplicationNum1 * multiplicationNum2;
    int divNum = (divisionNum1 / divisionNum2);

    int additionAnswer = 0;
    int subtractionAnswer = 0;
    int multiplicationAnswer = 0;
    int divisionAnswer = 0;

    int score = 0;

    try {
      additionAnswer = Integer.parseInt(additionResult);
      subtractionAnswer = Integer.parseInt(subtractionResult);
      multiplicationAnswer = Integer.parseInt(multiplicationResult);
      divisionAnswer = Integer.parseInt(divisionResult);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    // Validate addition
    if (additionAnswer != addNum) {
      hasError = true;
      getServletContext().setAttribute("additionError", true);
    } else {
      score++;
    }

    // Validate subtraction
    if (subtractionAnswer != subNum) {
      hasError = true;
      getServletContext().setAttribute("subtractionError", true);
    } else {
      score++;
    }

    // Validate multiplication
    if (multiplicationAnswer != multNum) {
      hasError = true;
      getServletContext().setAttribute("multiplicationError", true);
    } else {
      score++;
    }

    // Validate division
    if (divisionAnswer != divNum) {
      hasError = true;
      getServletContext().setAttribute("divisionError", true);
    } else {
      score++;
    }

    if (hasError) {
      doGet(request, response);
    } else {
      getServletContext().setAttribute("score", score);
      response.sendRedirect("Results");
    }
  }
}


