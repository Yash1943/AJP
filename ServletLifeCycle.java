import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletLifeCycle extends HttpServlet {
    String msg = " ";
    PrintWriter out;

    public void init() throws servletException{
        msg = "Hello World! :My First Servlet Program";
        public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletExcception , IOException
        {
            response.setContentType("text/html");
            out =response.getWriter();
            out.println(msg);
        }
        public void destory(){
            out.close();
        }
    }

}
