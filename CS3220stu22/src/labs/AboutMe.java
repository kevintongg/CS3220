package labs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Labs/AboutMe")
public class AboutMe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<!-- Latest compiled and minified CSS -->");
        out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        out.println("	<meta charset=\"UTF-8\">");
        out.println("	<title>About Me</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("	<div class=\"page-header\">");
        out.println("		<div id=\"name\"><h1>About Me <small>CS 3220 - Lab</small></h1></div>");
        out.println("	</div>");
        
		out.println("<form action=\"AboutMe\" method=\"post\">");
        out.println("<input type=\"text\" name=\"cin\" placeholder=\"Enter CIN\">");
        out.println("<input type=\"submit\" name=\"show\" value=\"Show\"/>");
        out.println("</form>");
    
        out.println("</div>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String cin = request.getParameter("cin");
    	
    	if (cin != null && !cin.equals("304708110")) {
			doGet(request, response);
			return;
		}

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("	<!-- Latest compiled and minified CSS -->");
        out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        out.println("	<meta charset=\"UTF-8\">");
        out.println("	<title>About Me</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("	<div class=\"page-header\">");
        out.println("		<div id=\"name\"><h1>Tong, Kevin <small>CS 3220</small></h1></div>");
        out.println("	</div>");
        out.println("	<p class=\"description lead\">");
        out.println("		For my programming experience, I can say that I don't have much albeit having been at CSULA for a year now. I did take a few programming classes at my community college (C++/Java/VB), but I feel that those classes did not really teach me a lot as much as it was to get your feet wet in the language itself so I did not learn much from these classes. My first real experience programming is when I transferred here to CSULA in Fall Quarter 2015. For what languages I have developed in: C++, albeit only for a very basic intro class (< 1000 lines), Visual Basic (< 500 lines), JavaScript (< 500 lines), and finally Java (> 2000 lines).");
        out.println("</p>");
        out.println("       <p class=\"description lead\">");
        out.println("           What I hope to gain from this class is a valuable experience in broadening my horizons in Java and also developing web applications. How I intend to use this newfound knowledge in the future from this course is perhaps do an idea I haven't thought about yet.");
        out.println("</p>");
        out.println("	<p class=\"description lead\">");
        out.println("		Something interesting about me is that I can speak in three languages although not all of them may be fluent. English, Mandarin (Conversational), and Cantonese (Limited).");
        out.println("</p>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
