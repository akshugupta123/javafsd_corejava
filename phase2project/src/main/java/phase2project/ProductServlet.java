package phase2project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

//import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
//import javax.servlet.ServletException; 
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.mysql.cj.jdbc.Driver; 
//import com.mysql.cj.jdbc.Driver;


/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	//public class ProductServlet extends HttpServlet { private static final long serialVersionUID = 1L;
	// Database connection details
	private static final String DB_URL = "jdbc:mysql://localhost:3306/products"; 
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "@Kshatha123";

  //  public ProductServlet() {
       // super();
        // TODO Auto-generated constructor stub
// }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}

		// Retrieve the product ID from the request
		String productId = request.getParameter("productId");
		// Validate the product ID (add your own validation logic) 
		if (productId == null || productId.isEmpty()) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is required");
		return;
		}
	// Database connection objects
	Connection conn = null;
	PreparedStatement stmt = null; 
	ResultSet rs = null;

	//private String id;
	try {
		// Establish a connection to the database
		DriverManager.registerDriver(new Driver());
		conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		// Prepare the SQL statement to retrieve product details 
		String sql = "SELECT * FROM products WHERE id = ?"; 
		stmt = conn.prepareStatement(sql); 
		stmt.setString(1, productId);

		ServletResponse response1 = null;
		//Execute the query
		rs = stmt.executeQuery();
		 //Prepare the response
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		// Display the product details in the response
		if (rs.next()) { int id = rs.getInt("id");
		String name = rs.getString("name");
		double price = rs.getDouble("price");
		//PrintWriter out;
		out.println("<html><body>");
		out.println("<h2>Product Details</h2>");
		out.println("<p>ID: " + id + "</p>");

		out.println("<p>Name: " + name + "</p>"); 
		out.println("<p>Price: " + price + "</p>");
		out.println("</body></html>");
	} 
	else {
	out.println("<html><body>");
	out.println("<h2>Product Not Found</h2>");
	out.println("</body></html>");
	}
}
catch (SQLException e) 
{
	e.printStackTrace();
} 
finally {
// Close the database
	 if (rs != null) { try { rs.close();
} catch (SQLException e) { e.printStackTrace();
}
}
if (stmt != null) { try { stmt.close();
} catch (SQLException e) {
	e.printStackTrace();

}
}
if (conn != null) { try { conn.close();
} catch (SQLException e) { e.printStackTrace();
}
}
}
}
}

	



