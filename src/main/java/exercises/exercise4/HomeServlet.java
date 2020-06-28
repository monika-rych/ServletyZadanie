package exercises.exercise4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isLogged = false;
        HttpSession session = req.getSession();
        Object att = session.getAttribute("isLogged");

        if (att != null) {
            isLogged = (boolean) att;
        }
        if (isLogged == true) {
            resp.getWriter().println("czesc");
        } else {
            resp.getWriter().println("idz sobie");
        }
    }
}
