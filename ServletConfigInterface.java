import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletConfigInterface extends HttpServlet {
    String msg = " ";
    PrintWriter out;

    public void init(ServletConfig config) throws servletException{
        msg = config.getInitparameter("name");

        public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletExcception , IOException
        {
            response.setContentType("text/html");
            out =response.getWriter();
            out.println("<h1>"+msg+"</h1>");
        }
        public void destory(){
            out.close();
        }
    }

}
