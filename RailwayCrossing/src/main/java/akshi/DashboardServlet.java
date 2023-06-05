package akshi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/railway";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "@Kshatha123";

    // JDBC driver and connection variables
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private Connection conn;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection to the database
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database connection error: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            // Close the database connection
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Prepare the SQL statement
            String searchName = request.getParameter("searchName");
            String sql = "SELECT * FROM railway_crossings";
            if (searchName != null && !searchName.isEmpty()) {
                sql += " WHERE name LIKE '%" + searchName + "%'";
            }
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Retrieve favorite crossings from session
            List<Integer> favoriteCrossings = (List<Integer>) request.getSession().getAttribute("favoriteCrossings");
            if (favoriteCrossings == null) {
                favoriteCrossings = new ArrayList<>();
                request.getSession().setAttribute("favoriteCrossings", favoriteCrossings);
            }

            // Generate HTML output
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Railway Crossings</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Railway Crossings</h1>");

            // Search form
            out.println("<h2>Search Railway Crossing</h2>");
            out.println("<form method=\"GET\" action=\"DashboardServlet\">");
            out.println("<input type=\"text\" name=\"searchName\" placeholder=\"Enter name\">");
            out.println("<input type=\"submit\" value=\"Search\">");
            out.println("</form>");

            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Address</th><th>Landmark</th><th>Schedules</th><th>Person</th><th>Status</th><th>Action</th></tr>");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String landmark = resultSet.getString("landmark");
                String schedules = resultSet.getString("schedules");
                String person = resultSet.getString("person");
                String status = resultSet.getString("status");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + address + "</td>");
                out.println("<td>" + landmark + "</td>");
                out.println("<td>" + schedules + "</td>");
                out.println("<td>" + person + "</td>");
                out.println("<td>" + status + "</td>");

                if (favoriteCrossings.contains(id)) {
                    out.println("<td><a href=\"DashboardServlet?removeFavorite=" + id + "\">Remove Favorite</a></td>");
                } else {
                    out.println("<td><a href=\"DashboardServlet?markFavorite=" + id + "\">Mark Favorite</a></td>");
                }

                out.println("</tr>");
            }

            out.println("</table>");

            // Favorite railway crossings
            out.println("<h2>Favorite Railway Crossings</h2>");
            if (favoriteCrossings.isEmpty()) {
                out.println("<p>No favorite crossings found.</p>");
            } else {
                out.println("<table>");
                out.println("<tr><th>ID</th><th>Name</th><th>Address</th><th>Landmark</th><th>Schedules</th><th>Person</th><th>Status</th><th>Action</th></tr>");

                for (int crossingId : favoriteCrossings) {
                    String sqlFavorite = "SELECT * FROM railway_crossings WHERE id = ?";
                    PreparedStatement statementFavorite = conn.prepareStatement(sqlFavorite);
                    statementFavorite.setInt(1, crossingId);
                    ResultSet resultSetFavorite = statementFavorite.executeQuery();

                    while (resultSetFavorite.next()) {
                        int id = resultSetFavorite.getInt("id");
                        String name = resultSetFavorite.getString("name");
                        String address = resultSetFavorite.getString("address");
                        String landmark = resultSetFavorite.getString("landmark");
                        String schedules = resultSetFavorite.getString("schedules");
                        String person = resultSetFavorite.getString("person");
                        String status = resultSetFavorite.getString("status");

                        out.println("<tr>");
                        out.println("<td>" + id + "</td>");
                        out.println("<td>" + name + "</td>");
                        out.println("<td>" + address + "</td>");
                        out.println("<td>" + landmark + "</td>");
                        out.println("<td>" + schedules + "</td>");
                        out.println("<td>" + person + "</td>");
                        out.println("<td>" + status + "</td>");
                        out.println("<td><a href=\"DashboardServlet?removeFavorite=" + id + "\">Remove Favorite</a></td>");
                        out.println("</tr>");
                    }

                    statementFavorite.close();
                }

                out.println("</table>");
            }

            out.println("</body>");
            out.println("</html>");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database error: " + e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String markFavoriteId = request.getParameter("markFavorite");
        String removeFavoriteId = request.getParameter("removeFavorite");

        // Retrieve favorite crossings from session
        List<Integer> favoriteCrossings = (List<Integer>) request.getSession().getAttribute("favoriteCrossings");

        if (favoriteCrossings == null) {
            favoriteCrossings = new ArrayList<>();
            request.getSession().setAttribute("favoriteCrossings", favoriteCrossings);
        }

        if (markFavoriteId != null && !markFavoriteId.isEmpty()) {
            int crossingId = Integer.parseInt(markFavoriteId);
            if (!favoriteCrossings.contains(crossingId)) {
                favoriteCrossings.add(crossingId);
            }
        } else if (removeFavoriteId != null && !removeFavoriteId.isEmpty()) {
            int crossingId = Integer.parseInt(removeFavoriteId);
            favoriteCrossings.remove((Integer) crossingId);
        }

        response.sendRedirect(request.getContextPath() + "/FavoriteCrossingsServlet");
    }
}