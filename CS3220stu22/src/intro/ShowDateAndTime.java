package intro;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Intro/ShowDateAndTime")
public class ShowDateAndTime extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = this.getServletContext();

        // Determine if the pageCounter already exists in the servlet context
        if (context.getAttribute("pageCounter") == null) {
            context.setAttribute("pageCounter", 0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get a reference to the application scope
        ServletContext context = this.getServletContext();

        // Get the current value of the page counter
        int counter = (int) context.getAttribute("pageCounter");

        // Increment the page counter, and update it in the application scope.
        context.setAttribute("pageCounter", ++counter);

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<!-- Latest compiled and minified CSS -->");
        out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        out.println("	<meta charset=\"UTF-8\">");
        out.println("	<title>Insert title here</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1><small>The current date/time is:</small>" + new java.util.Date() + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}