import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletContextInterface extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletExcception, IOException {
        response.setContentType("html/text");
        PrintWriter out = response.getWriter();

        ServletContext Context = getServletContext();

        String Collage = Context.getInitParameter("name");

        out.println("Collage name is" + Collage);
        out.close();
    }
}