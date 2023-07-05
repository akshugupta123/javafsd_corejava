import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            response.setContentType("text/html");
            response.getWriter().println("<h1>Welcome to the Dashboard!</h1>");
            response.getWriter().println("<a href=\"LogoutServlet\">Logout</a>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}
