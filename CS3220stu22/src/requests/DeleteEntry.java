package requests;

import model.GuestBookEntry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/requests/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get the index of the element to be deleted
		int id = Integer.parseInt(request.getParameter("id"));

		// Get a reference to our guestbook
		List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		// Remove the element at location 'index'
		for(GuestBookEntry entry : entries) {
			if (entry.getId() == id) {
				entries.remove(entry);
				break;
			}
		}
				
		// Redirect to our guestbook page
//		response.sendRedirect("GuestBook");
		response.getWriter().println("Your entry has been deleted.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
