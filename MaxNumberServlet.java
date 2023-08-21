import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaxNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the values of the two numbers from the request parameters
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        // Calculate the maximum of the two numbers
        double maxNumber = Math.max(num1, num2);

        // Prepare the response content
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Maximum Number</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Maximum Number</h1>");
        out.println("<p>The maximum of " + num1 + " and " + num2 + " is " + maxNumber + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
