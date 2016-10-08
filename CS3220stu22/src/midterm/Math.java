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

  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    List<Problem> problems = new ArrayList<>();

    problems.add(new Problem(1, 1));
    problems.add(new Problem(2, 2));
    problems.add(new Problem(3, 3));
    problems.add(new Problem(64, 8));
    problems.add(new Problem(81, 9));
    problems.add(new Problem(49, 7));
    problems.add(new Problem(36, 6));
    problems.add(new Problem(25, 5));
    problems.add(new Problem(16, 4));

    getServletContext().setAttribute("problems", problems);

  }

  @Override
  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();

    Problem problem = new Problem();
    List<Problem> problems = (ArrayList<Problem>) getServletContext().getAttribute("problems");

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
        "\t<div class=\"page-header\">\n" +
        "\t\t<h1>Math</h1>\n" +
        "\t\t<label class=\"text-right\">" + getServletContext().getAttribute("name") + "</label>" +
        "\t</div>");

    out.println("\t<form class=\"form-horizontal\" method=\"post\">\n");

    out.println("\t\t<div class=\"form-group\">\n");

    int additionNum1 = 0;
    int additionNum2 = 0;
    int additionCounter = 0;

    for (Problem p : problems) {
      Collections.shuffle(problems);
      additionNum1 = p.getNum1();
      additionNum2 = p.getNum2();
      Collections.shuffle(problems);
      additionCounter++;
      if (additionCounter == 2) {
        break;
      }
    }

    getServletContext().setAttribute("additionNum1", additionNum1);
    getServletContext().setAttribute("additionNum2", additionNum2);

    out.println("\t\t\t<label class=\"col-sm-2 control-label\">Addition: " + additionNum1 + " + " + additionNum2 + "</label>\n" +
        "\t\t\t<div class=\"col-sm-10\">\n" +
        "\t\t\t\t<input class=\"form-control\" type=\"text\" name=\"additionAnswer\" placeholder=\"Enter your answer\" autofocus>\n" +
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
        "\t\t<input class=\"form-control\" type=\"text\" name=\"subtractionAnswer\" placeholder=\"Enter your answer\">\n" +
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
        "\t\t<input class=\"form-control\" type=\"text\" name=\"multiplicationAnswer\" placeholder=\"Enter your answer\">\n" +
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
        "\t<label class=\"col-sm-2 control-label\">Division: " + divisionNum1 + " / " + divisionNum2 + "</label>\n" +
        "\t<div class=\"col-sm-10\">\n" +
        "\t\t<input class=\"form-control\" type=\"text\" name=\"divisionAnswer\" placeholder=\"Enter your answer\">\n" +
        "\t</div>\n" +
        "</div>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    boolean hasError = true;

    String additionNum1 = (String) getServletContext().getAttribute("additionNum1");
    String additionNum2 = (String) getServletContext().getAttribute("additionNum2");
    String subtractionNum1 = (String) getServletContext().getAttribute("subtractionNum1");
    String subtractionNum2 = (String) getServletContext().getAttribute("subtractionNum2");
    String multiplicationNum1 = (String) getServletContext().getAttribute("multiplicationNum1");
    String multiplicationNum2 = (String) getServletContext().getAttribute("multiplicationNum2");
    String divisionNum1 = (String) getServletContext().getAttribute("divisionNum1");
    String divisionNum2 = (String) getServletContext().getAttribute("divisionNum2");
    String additionResult = request.getParameter("additionAnswer");
    String subtractionResult = request.getParameter("subtractionAnswer");
    String multiplicationResult = request.getParameter("multiplicationAnswer");
    String divisionResult = request.getParameter("divisionAnswer");

    int additionAnswer = 0;
    int subtractionAnswer = 0;
    int multiplicationAnswer = 0;
    int divisionAnswer = 0;

    int addNum1 = 0;
    int addNum2 = 0;
    int subNum1 = 0;
    int subNum2 = 0;
    int multNum1 = 0;
    int multNum2 = 0;
    int divNum1 = 0;
    int divNum2 = 0;

    try {
      additionAnswer = Integer.parseInt(additionResult);
      subtractionAnswer = Integer.parseInt(subtractionResult);
      multiplicationAnswer = Integer.parseInt(multiplicationResult);
      divisionAnswer = Integer.parseInt(divisionResult);
      addNum1 = Integer.parseInt(additionNum1);
      addNum2 = Integer.parseInt(additionNum2);
      subNum1 = Integer.parseInt(subtractionNum1);
      subNum2 = Integer.parseInt(subtractionNum2);
      multNum1 = Integer.parseInt(multiplicationNum1);
      multNum2 = Integer.parseInt(multiplicationNum2);
      divNum1 = Integer.parseInt(divisionNum1);
      divNum2 = Integer.parseInt(divisionNum2);
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }

    // Validate addition
    if (additionAnswer != (addNum1 + addNum2)) {
      hasError = true;
      request.setAttribute("additionError", true);
    }

    // Validate subtraction
    if (subtractionAnswer != (subNum1 - subNum2)) {
      hasError = true;
      request.setAttribute("subtractionError", true);
    }

    // Validate multiplication
    if (multiplicationAnswer != (multNum1 * multNum2)) {
      hasError = true;
      request.setAttribute("multiplicationError", true);
    }

    // Validate division
    if (divisionAnswer != (divNum1 / divNum2)) {
      hasError = true;
      request.setAttribute("divisionError", true);
    }

  }
}

