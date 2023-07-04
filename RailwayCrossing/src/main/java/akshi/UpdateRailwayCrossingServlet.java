package akshi;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/UpdateRailwayCrossingServlet")
public class UpdateRailwayCrossingServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
// JDBC database URL, username, and password
private static final String DB_URL = "jdbc:mysql://localhost:3306/railway";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "@Kshatha123";
// JDBC driver class name
private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
protected void doPost(HttpServletRequest request, HttpServletResponse
response)
throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String address = request.getParameter("address");
String landmark = request.getParameter("landmark");
String schedules = request.getParameter("schedules");
String person = request.getParameter("person");
String status = request.getParameter("status");
Connection conn = null;
PreparedStatement statement = null;
try {
// Register the JDBC driver
Class.forName(JDBC_DRIVER);
// Create a connection to the database
conn = DriverManager.getConnection(DB_URL, DB_USERNAME,
DB_PASSWORD);
// Prepare the SQL statement
String sql = "UPDATE railway_crossings SET name=?, address=?, landmark=?, schedules=?, person=?, status=? WHERE id=?";
statement = conn.prepareStatement(sql);
statement.setString(1, name);
statement.setString(2, address);
statement.setString(3, landmark);
statement.setString(4, schedules);
statement.setString(5, person);
statement.setString(6, status);
statement.setInt(7, id);
// Execute the statement
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
// Railway crossing updated successfully
response.sendRedirect("GetRailwayDetailsServlet");
} else {
// Failed to update railway crossing
response.getWriter().println("Failed to update railway crossing. Please try again.");
}
} catch (ClassNotFoundException e) {
e.printStackTrace();
response.getWriter().println("JDBC driver not found.");
} catch (SQLException e) {
e.printStackTrace();
response.getWriter().println("Database error: " + e.getMessage());
} finally {
// Close the resources
if (statement != null) {
try {
statement.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
}
}
}