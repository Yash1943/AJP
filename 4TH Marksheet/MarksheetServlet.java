import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MarksheetServlet")
public class MarksheetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String enrollmentNumber = request.getParameter("enrollmentNumber");

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Set up database connection
            String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
            String dbUser = "your_db_username";
            String dbPassword = "your_db_password";
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Prepare SQL query
            String query = "SELECT * FROM marksheets WHERE enrollment_number = ? AND semester = 4";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enrollmentNumber);

            // Execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BTech Semester 4 Marks</title>");
            out.println("</head>");
            out.println("<body>");

            if (resultSet.next()) {
                out.println("<h1>BTech Semester 4 Marks for Enrollment Number: " + enrollmentNumber + "</h1>");
                out.println("<table border='1'>");
                out.println("<tr><th>Subject</th><th>Marks</th></tr>");

                do {
                    String subject = resultSet.getString("subject");
                    int marks = resultSet.getInt("marks");
                    out.println("<tr><td>" + subject + "</td><td>" + marks + "</td></tr>");
                } while (resultSet.next());

                out.println("</table>");
            } else {
                out.println("<h1>No marks found for the given enrollment number.</h1>");
            }

            out.println("</body>");
            out.println("</html>");

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("An error occurred while processing the request.");
        }
    }
}
