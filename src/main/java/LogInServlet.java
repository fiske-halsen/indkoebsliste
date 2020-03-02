import javax.servlet.ServletContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LogInServlet",urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = getServletContext();



        String navn = request.getParameter("navn");
        String kodeOrdet = request.getParameter("kodeord");

        if(servletContext.getAttribute("brugerMap") == null){

            Map<String, String> brugerMap = new HashMap<>();

            brugerMap.put("test", "test");
            brugerMap.put("admin", "1234");


            servletContext.setAttribute("brugerMap", brugerMap);
        }





        if( !( (Map<String,String>)servletContext.getAttribute("brugerMap")  ).containsKey(navn)   ){

            //todo gå til login side

            request.setAttribute("besked", "Velkommen til bruger login");
            request.getRequestDispatcher("WEB-INF/OpretBruger.jsp").forward(request,response);
        }





        if( ( (Map<String,String>)servletContext.getAttribute("brugerMap")  ).get(navn).equalsIgnoreCase(kodeOrdet)   ){

            //todo gå til huskelisten, hvis koden der bliver indtastet er korret
            if(navn.equalsIgnoreCase("admin")){

                request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);

            }


            response.getWriter().println("klar til login - alt er fint");
            request.getRequestDispatcher("WEB-INF/HuskeListe.jsp").forward(request,response);

        }

        //todo gå til login, dvs index, hvis koden der bliver indtastet er forkert.

        request.setAttribute("besked", "Din kode var forkert prøv igen");
        request.getRequestDispatcher("index.jsp").forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
