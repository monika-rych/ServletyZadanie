package exercises.exercise4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final String userName = "monika";
    private final String userPassword = "haslo";

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        if (userName.equals(name) && userPassword.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogged", true);

            session.setMaxInactiveInterval(30 * 60);

            resp.sendRedirect(req.getContextPath() + "/home");

        } else {
            PrintWriter out = resp.getWriter();
            out.println("Either user name or password is wrong");
        }
    }
}

